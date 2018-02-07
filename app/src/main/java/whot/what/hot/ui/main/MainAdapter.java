package whot.what.hot.ui.main;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import whot.what.hot.R;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MainAdapter extends BaseSectionQuickAdapter<MainSectionEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param layoutResId      The layout resource id of each item.
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public MainAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MainSectionEntity item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isHeader);
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainSectionEntity item) {
        //顯示instagram 讀取到的圖片
        Glide.with(mContext).load(item.t.getImages().getStandard_resolution().getUrl()).crossFade().into((ImageView) helper.getView(R.id.iv));
        helper.setText(R.id.tv, item.t.getLocation().getName());
    }
}
