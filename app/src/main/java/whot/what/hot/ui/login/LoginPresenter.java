package whot.what.hot.ui.login;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import java.util.List;

import whot.what.hot.api.ApiServices;
import whot.what.hot.base.BasePresenter;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Kevin on 12/10/2017.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    LoginPresenter(LoginView view) {
        attachView(view);
    }

    public LoginPresenter(ApiServices apiServices, LoginView view) {
        this.apiServices = apiServices;
        attachView(view);
    }

    @SuppressLint("StaticFieldLeak")
    void onLoadAccount(){
        mvpView.showLoading();
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user.db").build();
        /* 讀取Room資料庫的使用者電子郵件資料，
         * 並且給AutoCompleteTextView使用*/
        new AsyncTask<Void, Void, List<LoginEntity>>() {
            @Override
            protected List<LoginEntity> doInBackground(Void... params) {
                return db.loginDao().fetchAllUsers();
            }

            @Override
            protected void onPostExecute(List<LoginEntity> usersData) {
                //判斷資資料是否存在後在寫入ArrayAdapter儲存
                if (usersData.size() > 0) {
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);
                    for (LoginEntity value : usersData) adapter.add(value.getEmail());
                    mvpView.fetchAccount(adapter);
                }
            }
        }.execute();
        mvpView.hideLoading();
    }
}
