package whot.what.hot.base;

import whot.what.hot.api.ApiServices;
import whot.what.hot.http.RetrofitManager;

/**
 * Created by sapido on 22/09/2017.
 */

public class BasePresenter<V> {
    public V mvpView;
    protected ApiServices apiServices;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        //指定url
        apiServices = RetrofitManager.getDefault("https://api.instagram.com/");
    }

    public void detachView() {
        this.mvpView = null;
        RetrofitManager.removeService();
    }
}
