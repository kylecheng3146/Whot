package kevin.practise.example.base;

import kevin.practise.example.api.ApiServices;
import kevin.practise.example.http.RetrofitManager;

/**
 * Created by sapido on 22/09/2017.
 */

public class BasePresenter<V> {
    public V mvpView;
    protected ApiServices apiServices;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        //指定url
        apiServices = RetrofitManager.getDefault("http://211.22.242.13:8164");
    }

    public void detachView() {
        this.mvpView = null;
    }
}
