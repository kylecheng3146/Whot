package whot.what.hot.ui.main;

import whot.what.hot.api.ApiServices;
import whot.what.hot.base.BasePresenter;
import whot.what.hot.data.InstagramTagModel;
import whot.what.hot.http.RxManager;
import whot.what.hot.http.RxSubscriber;

/**
 * Created by Kevin on 2018/2/6.
 */

public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView view) {
        attachView(view);
    }

    public MainPresenter(ApiServices apiServices, MainView view) {
        this.apiServices = apiServices;
        attachView(view);
    }

    void loadInstagramData(){
        mvpView.showLoading();
        RxSubscriber.getInstance().doSubscribe(apiServices.getInstagramGson("v1/tags/tainan/media/recent?access_token=315272341.7fb3c50.8d63aaf6d07943238abac3a1b0866c16"), new RxManager<InstagramTagModel>() {
            @Override
            public void _onNext(InstagramTagModel model) {
                mvpView.fetchTagResult(model);
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
