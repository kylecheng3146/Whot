package kevin.practise.example.ui.login;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/** 測試ROOM DAO 是否可行
 * Created by Kevin on 02/11/2017.
 */

public class SimpleEntityReadWriteTest {
    private LoginDao loginDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        //將資料庫建在內存中，可以讓你的測試整體更加一體化，更密閉。
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        loginDao = mDb.loginDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        /*新增一筆使用者資料，並將資料查詢出來，
          驗證是否有寫入成功*/
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setEmail("foo@bar.com");
        loginDao.insertUsers(loginEntity);
        List<LoginEntity> email = loginDao.fetchAllUsers();
        assertThat(email.get(0).getEmail(), equalTo("foo@bar.com"));
    }
}
