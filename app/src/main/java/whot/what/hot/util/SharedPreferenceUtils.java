package whot.what.hot.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by APP01 on 2016/12/2.
 */

public class SharedPreferenceUtils {
    private static final String FILE_NAME = "user_data";

    public static void setEmail(Context context, String email) {
        //1.產生SharedPreference
        SharedPreferences pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        //2.取得寫入至 xml 物件
        SharedPreferences.Editor edit = pref.edit();
        //3.寫入資料
        edit.putString("email", email);
        //4.確認寫入
        edit.apply();
    }

    public static String getEmail(Context context) {
        //1.產生SharedPreference
        SharedPreferences pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        //2.讀取資料
        return pref.getString("email", "");
    }
}
