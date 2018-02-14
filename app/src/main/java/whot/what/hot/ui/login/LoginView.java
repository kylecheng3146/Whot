package whot.what.hot.ui.login;

import android.widget.ArrayAdapter;

import whot.what.hot.base.BaseView;

/**
 * Created by Kevin on 12/10/2017.
 */

public interface LoginView  extends BaseView {
    //登入按鈕
    void onLoginClick();
    //密碼輸入完成按鈕
    boolean onPasswordEditorDone(int actionId);
    //FB登入按鈕
    void onFacebookLoginClick();

    void fetchAccount(ArrayAdapter<String> adapter);
}
