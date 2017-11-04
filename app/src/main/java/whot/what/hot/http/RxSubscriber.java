package whot.what.hot.http;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kevin on 11/10/2017.
 */

public class RxSubscriber {
    private static RxSubscriber rxSubscriber = null;

    private RxSubscriber() {
        //do nothing..
    }

    public synchronized static RxSubscriber getInstance() {
        if (rxSubscriber == null) {
            rxSubscriber = new RxSubscriber();
        }
        return rxSubscriber;
    }


    public <T> Subscription doSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public <T> Subscription doIoSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public <T> Observable<T> doSubscribe(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
