package whot.what.hot.ui.home;

import com.chad.library.adapter.base.entity.SectionEntity;

import whot.what.hot.data.InstagramTagModel;

/**
 * Created by Kevin on 2018/3/1.
 */

public class HomeSectionEntity extends SectionEntity<InstagramTagModel.DataBean> {
    private boolean isMore;
    public HomeSectionEntity(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMore = isMroe;
    }
    public HomeSectionEntity(InstagramTagModel.DataBean t) {
        super(t);
    }
}

