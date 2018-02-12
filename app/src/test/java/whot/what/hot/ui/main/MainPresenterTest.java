package whot.what.hot.ui.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;
import whot.what.hot.api.ApiServices;
import whot.what.hot.data.InstagramTagModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Kevin on 2018/2/12.
 */
public class MainPresenterTest {

    private MainPresenter mainPresenter;
    private MainView mainView;
    private ApiServices apiServices;

    @BeforeClass
    public static void openRxTools(){
        RxAndroidSchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        };

        RxJavaSchedulersHook rxJavaSchedulersHook = new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        };
        // reset()不是必要，實踐中發現不寫reset()，偶爾會出錯，所以寫上保險
        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);
        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(rxJavaSchedulersHook);
    }

    @Before
    public void setUp() throws Exception {
        // 生成mock對象
        mainView = mock(MainView.class);
        apiServices = mock(ApiServices.class);

        mainPresenter = new MainPresenter(apiServices, mainView);
    }

    @Test
    public void testTagResult() throws Exception {
        InstagramTagModel instagram = new InstagramTagModel();
        when(apiServices.getInstagramGson("v1/tags/tainan/media/recent?access_token=315272341.7fb3c50.8d63aaf6d07943238abac3a1b0866c16")).thenReturn(Observable.just(instagram));
        mainPresenter.loadInstagramData();
        ArgumentCaptor<InstagramTagModel> captor = ArgumentCaptor.forClass(InstagramTagModel.class);
        verify(mainView).fetchTagResult(captor.capture());
        instagram = captor.getValue();
        Assert.assertEquals(200,instagram.getMeta().getCode());
    }

}
