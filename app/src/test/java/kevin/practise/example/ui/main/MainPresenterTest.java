package kevin.practise.example.ui.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.HashMap;

import kevin.practise.example.api.ApiServices;
import kevin.practise.example.data.AntModel;
import kevin.practise.example.data.MainModel;
import rx.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Kevin on 18/10/2017.
 */
public class MainPresenterTest {

    MainPresenter mainPresenter;
    MainView mainView;
    ApiServices apiServices;

    @Before
    public void setUp() throws Exception {
        RxUnitTestTools.openRxTools();

        // 生成mock對象
        mainView = mock(MainView.class);
        apiServices = mock(ApiServices.class);

        mainPresenter = new MainPresenter(apiServices,mainView);
    }

    @Test
    public void testNotificationData() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("IMEI", "355693063092533");
        hashMap.put("CusID", "0005967");
        hashMap.put("TimeStamp", "1497235728");
        hashMap.put("Signature", "ce42ccc9a6da004321c8f4dab7632c6b849245669634c155a9497afdc6fdfe11");
        hashMap.put("AppID", "20170518A");

        MainModel mainModel = new MainModel();

        when(apiServices.getNotificationCountWithRxJava("api/Android/NotifiListCount", hashMap)).thenReturn(Observable.just(mainModel));
        mainPresenter.loadDataByRetrofitRxJava(hashMap);

        ArgumentCaptor<MainModel> captor = ArgumentCaptor.forClass(MainModel.class);

        verify(mainView).getNotificationData(captor.capture());
        mainModel = captor.getValue();

        Assert.assertEquals(mainModel.isResult(),true);
    }

    @Test
    public void testAntResult() throws Exception {
        AntModel antModel = new AntModel();
        when(apiServices.getAntInfoWithGson("https://script.google.com/macros/s/AKfycbxxgTSWXbEiX8EHBSWrt6PVDnMAfmM3FLYDAhy-cqgDTRVY6hA/exec")).thenReturn(Observable.just(antModel));
        mainPresenter.loadAntData();
        ArgumentCaptor<AntModel> captor = ArgumentCaptor.forClass(AntModel.class);
        verify(mainView).getAntResult(captor.capture());
        antModel = captor.getValue();
        Assert.assertEquals(antModel.getName(),"Ant");
    }

}
