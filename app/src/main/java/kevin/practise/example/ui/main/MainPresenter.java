package kevin.practise.example.ui.main;

import java.util.HashMap;
import java.util.Map;

import kevin.practise.example.base.BasePresenter;
import kevin.practise.example.data.MainModel;
import kevin.practise.example.data.WeatherDataModel;
import kevin.practise.example.http.RxManager;
import kevin.practise.example.http.RxSubscriber;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 處理 main 業務邏輯
 * Created by kevin on 21/09/2017.
 */

class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        attachView(view);
    }

    /**
     * RxJava範例
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
     * Retrofit post example
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
     * Retrofit post example
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
}
