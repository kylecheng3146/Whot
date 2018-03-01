package whot.what.hot.ui.home;

import whot.what.hot.base.BaseView;
import whot.what.hot.data.InstagramTagModel;

/**
 * Created by Kevin on 2018/3/1.
 */

public interface HomeView extends BaseView {
    void fetchTagResult(InstagramTagModel bean);
}
