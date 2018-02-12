package whot.what.hot.ui.main;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import whot.what.hot.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/** 測試首頁所有ui事件
 * Created by Kevin on 2018/2/12.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testClickDrawerLayout() throws Exception{
        //先暫停等待view載入完成防止 No views in hierarchy found matching: with id
        Thread.sleep(2000);
        // 測試打開側邊欄
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        //測試是否正確點擊成功
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
    }
}
