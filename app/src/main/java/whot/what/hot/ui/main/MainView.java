package whot.what.hot.ui.main;

import whot.what.hot.base.BaseView;
import whot.what.hot.data.AntModel;
import whot.what.hot.data.GankModel;
import whot.what.hot.data.MainModel;

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
