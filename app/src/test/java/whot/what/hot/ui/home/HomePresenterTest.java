package whot.what.hot.ui.home;

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
public class HomePresenterTest {

    private HomePresenter homePresenter;
    private HomeView homeView;
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
        homeView = mock(HomeView.class);
        apiServices = mock(ApiServices.class);
        homePresenter = new HomePresenter(apiServices, homeView);
    }

    @Test
    public void testTagResult() throws Exception {
        InstagramTagModel instagram = new InstagramTagModel();
        when(apiServices.getInstagramGson("v1/tags/tainan/media/recent?access_token=315272341.7fb3c50.8d63aaf6d07943238abac3a1b0866c16")).thenReturn(Observable.just(instagram));
        homePresenter.loadInstagramData();
        ArgumentCaptor<InstagramTagModel> captor = ArgumentCaptor.forClass(InstagramTagModel.class);
        verify(homeView).fetchTagResult(captor.capture());
        instagram = captor.getValue();
        Assert.assertEquals(200,instagram.getMeta().getCode());
        Assert.assertEquals(null,instagram.getData().get(0).getAttribution());
        Assert.assertEquals("1717337832987387452_315272341",instagram.getData().get(0).getId());
        Assert.assertNotEquals("1717337832987387452_315272341",instagram.getData().get(0).getCreated_time());
        Assert.assertNotEquals(null,instagram.getData().get(0).getComments());
        Assert.assertNotEquals(null,instagram.getData().get(0).getCaption());
        Assert.assertEquals("Lo-fi",instagram.getData().get(0).getFilter());
        Assert.assertEquals("image",instagram.getData().get(0).getType());
        Assert.assertNotEquals(null,instagram.getData().get(0).getLikes());
        Assert.assertEquals(0,instagram.getData().get(0).getUsers_in_photo().size());
        Assert.assertNotEquals(null,instagram.getData().get(0).getUser());
        Assert.assertNotEquals(null,instagram.getData().get(0).getTags());
        Assert.assertEquals("https://www.instagram.com/p/BfVNakGjWY8/",instagram.getData().get(0).getLink());
        Assert.assertEquals("next_max_id and min_id are deprecated for this endpoint; use min_tag_id and max_tag_id instead",instagram.getPagination().getDeprecation_warning());
        Assert.assertNotEquals("AQCd4G7rM_tHGHqd-wLIXhsfg0Ek39iuPL5IwvswE95QDgyULexvURjqA-MAG_XmG5QSDH_yf0iH-1PcaRBiSO9FoPpjDsbhioKSS8WVFb1EaA",instagram.getPagination().getMin_tag_id());
        Assert.assertNotEquals("AQCd4G7rM_tHGHqd-wLIXhsfg0Ek39iuPL5IwvswE95QDgyULexvURjqA-MAG_XmG5QSDH_yf0iH-1PcaRBiSO9FoPpjDsbhioKSS8WVFb1EaA",instagram.getPagination().getNext_min_id());
    }

}
