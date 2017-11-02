package kevin.practise.example.ui.login;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import kevin.practise.example.R;
import kevin.practise.example.base.BaseActivity;
import kevin.practise.example.ui.test.TestActivity;
import kevin.practise.example.util.CommonUtils;
import kevin.practise.example.util.SharedPreferenceUtils;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    // UI references.
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.email_login_form) LinearLayout emailLoginForm;

    private AutoCompleteTextView etEmail,etPassword;
    private LoginPresenter presenter;

    private LoginEntity loginEntity;
    private LoginDao loginDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        etEmail = findViewById(R.id.et_mail);
        etPassword = findViewById(R.id.et_password);
        etEmail.setText(SharedPreferenceUtils.getEmail(this));
    }

    @OnClick(R.id.btn_login)
    @Override
    public void onLoginClick() {

        View focusView = null;
        // Reset errors.
        etEmail.setError(null);
        etPassword.setError(null);

        // Store values at the time of the login attempt.
        final String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            etEmail.setError(getString(R.string.error_field_required));
            focusView = etEmail;
            focusView.requestFocus();
            return;
        }
        // Check for a valid email rule
        if (!CommonUtils.isEmailValid(email)) {
            etEmail.setError(getString(R.string.error_invalid_email));
            focusView = etEmail;
            focusView.requestFocus();
            return;
        }
        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !CommonUtils.isPasswordValid(password)) {
            etPassword.setError(getString(R.string.error_invalid_password));
            focusView = etPassword;
            focusView.requestFocus();
            return;
        }

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "user.db").build();

        //執行寫入資料庫的動作
        new Thread() {
            @Override
            public void run() {
                super.run();
                loginDao = db.loginDao();
                loginEntity = new LoginEntity();
                loginEntity.setEmail(email);
                loginDao.insertUsers(loginEntity);
            }
        }.start();

        //紀錄登入的電子郵件到SharedPreference後跳轉頁面到首頁
        SharedPreferenceUtils.setEmail(this,email);
        CommonUtils.intentActivity(this, TestActivity.class);
//        presenter = new LoginPresenter(this);

    }

    @OnEditorAction(R.id.et_password)
    @Override
    public boolean onPasswordEditorDone(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onLoginClick();
            return true;
        }
        return false;
    }
}

