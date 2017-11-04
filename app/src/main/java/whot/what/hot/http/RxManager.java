package whot.what.hot.http;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by sapido on 22/09/2017.
 */

public abstract class RxManager<M> extends Subscriber<M> {

    public abstract void _onNext(M model);

    public abstract void _onError(String msg);

    public abstract void _onCompleted();


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
//            int code = httpException.code();
//            String msg = ;
//            if (code == 502 || code == 404) {
//                msg = "伺服器異常，請稍後再試";
//            }
            _onError(httpException.getMessage());
        } else {
            _onError(e.getMessage());
        }
        _onCompleted();
    }

    @Override
    public void onNext(M model) {
        _onNext(model);

    }

    @Override
    public void onCompleted() {
        _onCompleted();
    }
}
