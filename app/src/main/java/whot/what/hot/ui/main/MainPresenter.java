package whot.what.hot.ui.main;

import java.util.HashMap;
import java.util.Map;

import whot.what.hot.api.ApiServices;
import whot.what.hot.base.BasePresenter;
import whot.what.hot.data.AntModel;
import whot.what.hot.data.GankModel;
import whot.what.hot.data.MainModel;
import whot.what.hot.data.WeatherDataModel;
import whot.what.hot.http.RxManager;
import whot.what.hot.http.RxSubscriber;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 處理 main 業務邏輯
 * Created by kevin on 21/09/2017.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public MainPresenter(ApiServices apiServices, MainView view) {
        this.apiServices = apiServices;
        attachView(view);
    }
    /**
     * RxJava範例
     * @param hashMap [POST參數]
     * */
    void loadDataByRetrofitRxJava(HashMap<String, String> hashMap) {
        mvpView.showLoading();
        //call api method with rxjava example
        RxSubscriber.getInstance().doSubscribe(apiServices.getNotificationCountWithRxJava("/api/Android/NotifiListCount", hashMap), new RxManager<MainModel>() {
            @Override
            public void _onNext(MainModel model) {
                mvpView.getNotificationData(model);
                mvpView.showMessage(model.isResult()?model.getResponse(): (String) model.getErrorMessage());
            }

            @Override
            public void _onError(String msg) {
                mvpView.showMessage(msg);
            }

            @Override
            public void _onCompleted() {
                mvpView.hideLoading();
                detachView();
            }
        });
    }

    /**
     * RetrofitPost
     * @param hashMap [POST參數]
     * */
    void loadDataByRetrofitPost(HashMap<String, String> hashMap) {
        mvpView.showLoading();
        //call api method
        apiServices.getNotificationCount("api/Android/NotifiListCount", hashMap).enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                mvpView.getRetrofitPost(response.body());
                mvpView.showMessage(response.body().isResult()?response.body().getResponse(): (String) response.body().getErrorMessage());
                mvpView.hideLoading();
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                mvpView.showMessage(t.getMessage());
                mvpView.hideLoading();
            }
        });
    }

    /**
     * GET參數拼接
     * @param hashMap [GET 拼接參數 ex:abc=123&dfg=456]
     * */
    void loadDataByRetrofitCombine(Map<String,String> hashMap) {
        mvpView.showLoading();
        //轉換URL給定完整的URL網址
        RxSubscriber.getInstance().doSubscribe(apiServices.getWeatherWithParameters("http://op.juhe.cn/onebox/weather/query?", hashMap), new RxManager<WeatherDataModel>() {
            @Override
            public void _onNext(WeatherDataModel model) {
                mvpView.showMessage(String.valueOf(model.getResult().getData().getDate()));
            }

            @Override
            public void _onError(String msg) {
                mvpView.showMessage(msg);
            }

            @Override
            public void _onCompleted() {
                mvpView.hideLoading();
                detachView();
            }
        });
    }

    /**
     * GET參數請求
     * */
    void loadDataByRetrofitParameter(){
        mvpView.showLoading();
        RxSubscriber.getInstance().doSubscribe(apiServices.getAndroidInfoWithParameters("http://gank.io/api/data/Android/10/1"), new RxManager<GankModel>() {
            @Override
            public void _onNext(GankModel model) {
                mvpView.getRetrofitParameter(model);
                mvpView.showMessage(model.getResults().get(0).getDesc());
            }

            @Override
            public void _onError(String msg) {
                mvpView.showMessage(msg);
            }

            @Override
            public void _onCompleted() {
                mvpView.hideLoading();
                detachView();
            }
        });
    }

    void loadAntData(){
        mvpView.showLoading();
        RxSubscriber.getInstance().doSubscribe(apiServices.getAntInfoWithGson("https://script.google.com/macros/s/AKfycbxxgTSWXbEiX8EHBSWrt6PVDnMAfmM3FLYDAhy-cqgDTRVY6hA/exec"), new RxManager<AntModel>() {
            @Override
            public void _onNext(AntModel model) {
                mvpView.getAntResult(model);
            }

            @Override
            public void _onError(String msg) {
                mvpView.showMessage(msg);
            }

            @Override
            public void _onCompleted() {
                mvpView.hideLoading();
                detachView();
            }
        });
    }
}
