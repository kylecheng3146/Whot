package kevin.practise.example.ui.main;

import kevin.practise.example.base.BaseView;
import kevin.practise.example.data.AntModel;
import kevin.practise.example.data.GankModel;
import kevin.practise.example.data.MainModel;

/** MAIN VIEW LOGIC
 * Created by Kevin on 22/09/2017.
 */

public interface MainView extends BaseView {

    void getNotificationData(MainModel bean);

    void getRetrofitPost(MainModel bean);

    void getRetrofitParameter(GankModel bean);

    void getAntResult(AntModel bean);

    void onRxJavaClick();

    void onRetrofitPostClick();

    void onRetrofitCombineClick();

    void onRetrofitParameterClick();
}
