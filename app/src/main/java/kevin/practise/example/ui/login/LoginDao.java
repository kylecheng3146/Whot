package kevin.practise.example.ui.login;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Kevin on 01/11/2017.
 */
@Dao
public interface LoginDao {

    /*onConflict用來指定當發生衝突是的策略。 比如將@index的獨特屬性設置為true，
    當產生衝突時，默認情況下為OnConflictStrategy.ABORT會導致崩潰，
    這裡設置為OnConflictStrategy.REPLACE，當發生衝突時替換舊數據。*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(LoginEntity... users);

    @Insert
    void insertBothUsers(LoginEntity user1, LoginEntity user2);

    /*@Update註解的方法還可以返回INT，表示受影響的行數。*/
    @Update
    void updateUsers(LoginEntity... users);

    /*@Delete註解的方法還可以返回INT，表示受影響的行數。*/
    @Delete
    void deleteUsers(LoginEntity... users);

    @Query("SELECT * FROM user")
    List<LoginEntity> fetchAllUsers();

    /* @Query的值中支持添加綁定參數，該參數必須找到與之匹配的方法參數，
     * 並取得該方法參數的值，這邊傳入單個參數。*/
    @Query("SELECT * FROM user WHERE email = :email")
    LoginEntity[] loadUsersByEmail(int email);

//    /*可傳入多個參數*/
//    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
//    LoginEntity[] loadAllLoginEntitysBetweenAges(int minAge, int maxAge);
//
//    /*可傳入多個參數*/
//    @Query("SELECT * FROM user WHERE first_name LIKE :search " + "OR last_name LIKE :search")
//    List<LoginEntity> findUserWithName(String search);
//
//    /*可傳入多個參數的陣列方法*/
//    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
//    List<LoginEntity> loadUsersFromRegions(List<String> regions);
}
