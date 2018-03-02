package whot.what.hot.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import whot.what.hot.R;
import whot.what.hot.base.BaseFragment;
import whot.what.hot.data.InstagramTagModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements HomeView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //讀取instagram tag 資訊
        HomePresenter presenter = new HomePresenter(this);
        presenter.loadInstagramData();
    }

    @Override
    public void fetchTagResult(InstagramTagModel bean) {
        //設定標頭與資料
        List<HomeSectionEntity> list = new ArrayList<>();
        //在這邊以hash tag作為標頭
        list.add(new HomeSectionEntity(true, "#tainan", true));
        //將instagram 資料加入到content之中
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(new HomeSectionEntity(bean.getData().get(i)));
        }
        //spanCount 設定每行幾個項目
        rvList.setLayoutManager(new GridLayoutManager(mActivity, 2));
        //設定要傳入的參數
        HomeAdapter mainAdapter = new HomeAdapter(R.layout.item_tag_content, R.layout.def_tag_head, list);
        mainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeSectionEntity mainSectionEntity = list.get(position);
                showMessage(mainSectionEntity.t.getLocation().getName());
            }
        });
        //標頭按下more的事件
        mainAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showMessage("onItemChildClick" + position);
            }
        });
        rvList.setAdapter(mainAdapter);
    }
}
