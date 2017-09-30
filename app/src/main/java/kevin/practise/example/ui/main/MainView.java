package kevin.practise.example.ui.main;

import kevin.practise.example.base.BaseView;
import kevin.practise.example.data.MainModel;

/** MAIN VIEW LOGIC
 * Created by Kevin on 22/09/2017.
 */

public interface MainView extends BaseView {

    void getNotificationData(MainModel bean);

    void getRetrofitPost(MainModel bean);

    void onRxJavaClick();

    void onRetrofitPost();

    void onRetrofitCombine();
}
