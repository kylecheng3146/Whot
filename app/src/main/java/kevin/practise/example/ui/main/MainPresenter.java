package kevin.practise.example.ui.main;

import java.util.HashMap;

import kevin.practise.example.base.BasePresenter;
import kevin.practise.example.data.NotificationCountBean;
import kevin.practise.example.http.RxManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 處理 main業務邏輯
 * Created by kevin on 21/09/2017.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    /**
     * RxJava範例
     * */
    public void loadDataByRetrofitRxjava(HashMap hashMap) {
        mvpView.showLoading();
        apiServices.getNotificationCountWithRxJava("/api/Android/NotifiListCount",hashMap)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxManager<NotificationCountBean>() {
            @Override
            public void _onNext(NotificationCountBean bean) {
                mvpView.getNotificationData(bean);
                mvpView.showMessage(bean.getResponse());
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
