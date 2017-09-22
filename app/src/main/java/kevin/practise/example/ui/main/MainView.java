package kevin.practise.example.ui.main;

import kevin.practise.example.base.BaseView;
import kevin.practise.example.data.NotificationCountBean;

/**
 * Created by sapido on 22/09/2017.
 */

public interface MainView extends BaseView {

    void getNotificationData(NotificationCountBean bean);

    void onRxJavaClick();
}
