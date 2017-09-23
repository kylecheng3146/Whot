package kevin.practise.example.base;

/**
 * Created by sapido on 21/09/2017.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void onRefreshView();
}
