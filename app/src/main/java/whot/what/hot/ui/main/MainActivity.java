package whot.what.hot.ui.main;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;

import org.json.JSONObject;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import whot.what.hot.R;
import whot.what.hot.base.BaseActivity;
import whot.what.hot.ui.home.HomeFragment;
import whot.what.hot.ui.nearby.NearByFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) translationFragment(HomeFragment.class);
        //新增懸浮按鈕
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        //Action bar 加入 drawer layout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        //初始化導覽抽屜的個人詳細資料圖示及文字訊息
        initNavHeaderView(navView.inflateHeaderView(R.layout.nav_header_main));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_suggestion) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                translationFragment(HomeFragment.class);
                break;
            case R.id.nav_hot:
                break;
            case R.id.nav_nearby:
                translationFragment(NearByFragment.class);
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 初始化nav header view 取得裡面的元件
     * @param view [nav header view]
     * */
    private void initNavHeaderView(View view){
        ImageView ivPicture = view.findViewById(R.id.iv_picture);
        TextView tvName = view.findViewById(R.id.tv_name);
        Bundle params = new Bundle();
        params.putString("fields", "id,email,gender,cover,picture.type(large)");
        //讀取facebook profile image and id
        new GraphRequest(AccessToken.getCurrentAccessToken(), "me", params, HttpMethod.GET,
                response -> {
                    if (response != null) {
                        try {
                            JSONObject data = response.getJSONObject();
                            if (data.has("picture")) {
                                URL url = new URL(data.getJSONObject("picture").getJSONObject("data").getString("url"));
                                //使用 glide 圓形圖示
                                Glide.with(mActivity).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivPicture) {
                                    @Override
                                    protected void setResource(Bitmap resource) {
                                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(mActivity.getResources(), resource);
                                        circularBitmapDrawable.setCircular(true);
                                        ivPicture.setImageDrawable(circularBitmapDrawable);
                                    }
                                });
                                tvName.setText(data.getString("id"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).executeAsync();

    }
}
