package whot.what.hot.ui.main;

import whot.what.hot.base.BaseView;
import whot.what.hot.data.InstagramTagModel;

/**
 * Created by Kevin on 2018/2/6.
 */

public interface MainView extends BaseView{
    void fetchTagResult(InstagramTagModel bean);
}
