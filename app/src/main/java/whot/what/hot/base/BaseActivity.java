package whot.what.hot.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.login.LoginManager;

import butterknife.ButterKnife;
import whot.what.hot.R;
import whot.what.hot.util.CommonUtils;

/** every activity extends base
 * Created by Kevin on 21/09/2017.
 */

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    public Activity mActivity;
    private ProgressDialog mProgressDialog;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
        mActivity = this;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();//返回
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefreshView() {

    }

    /**
     * 虛擬返回鍵事件
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if("LoginActivity".equals(BaseActivity.this.getClass().getSimpleName())){
                //判斷連續按兩次返回鍵離開主程式
                if (doubleBackToExitPressedOnce) {
                    ActivityCompat.finishAffinity(this);
                    return super.onKeyDown(keyCode, event);
                }
                this.doubleBackToExitPressedOnce = true;
                showMessage(getString(R.string.alert_back_click_twice));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce=false;
                    }
                }, 2000);
            }else{
                //facebook 登出
                LoginManager.getInstance().logOut();
                this.finish();
            }
        }
        return false;
    }

    /**
     * fragment 轉換頁面
     * @param c [Fragment class]
     * */
    protected void translationFragment(Class<?> c){
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().replace(R.id.fl_content, (Fragment) c.newInstance()).commit();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
