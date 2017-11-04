package whot.what.hot.ui.login;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/** Android Room entity
 * 登入儲存自動填入的電子郵件資訊
 * Created by Kevin on 01/11/2017.
 */

/*
 * @Entity（tableName =“login”）聲明這是一個實體類。
 * 其中，tableName如果不寫，那麼默認類名就是表名。
 * @Index(value = {"email"}, unique = true) 聲明索引以及不允許鍵入重複值
 * */
@Entity(tableName = "user",indices = {@Index(value = {"email"}, unique = true)})
public class LoginEntity {
    /* @PrimaryKey（autoGenerate = true）聲明這是一個主鍵。
     * 其中，autoGenerate = true代表自動生成，
     * 而且會隨著數據增加自增長，可以理解成就是AUTOINCRESEMENT*/
    @PrimaryKey(autoGenerate = true)
    private int _id;

    /*通過使用 @ColumnInfo 註解定義自己的列名*/
    @ColumnInfo(name = "email")
    private String email;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* Room會利用@Entity註解的類的所有字段來創建表的列，
     * 如果某些字段不希望儲存的話，
     * 使用@Ignore註解該字段。*/
    @Ignore
    Bitmap picture;
}
