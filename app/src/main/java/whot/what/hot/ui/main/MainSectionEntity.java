package whot.what.hot.ui.main;

import com.chad.library.adapter.base.entity.SectionEntity;

import whot.what.hot.data.InstagramTagModel;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MainSectionEntity extends SectionEntity<InstagramTagModel.DataBean> {
    private boolean isMore;
    public MainSectionEntity(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMore = isMroe;
    }
    public MainSectionEntity(InstagramTagModel.DataBean t) {
        super(t);
    }
}
