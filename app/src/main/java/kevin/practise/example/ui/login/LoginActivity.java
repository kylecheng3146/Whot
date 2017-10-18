package kevin.practise.example.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import kevin.practise.example.R;
import kevin.practise.example.base.BaseActivity;
import kevin.practise.example.util.CommonUtils;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    // UI references.
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.email_login_form) LinearLayout emailLoginForm;
    @BindView(R.id.et_mail) EditText etEmail;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    @Override
    public void onLoginClick() {

        View focusView = null;
        // Reset errors.
        etEmail.setError(null);
        etPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !CommonUtils.isPasswordValid(password)) {
            etPassword.setError(getString(R.string.error_invalid_password));
            focusView = etPassword;
            focusView.requestFocus();
            return;
        }

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

        presenter = new LoginPresenter(this);
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

