package whot.what.hot.ui.home;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import whot.what.hot.R;
import whot.what.hot.ui.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/** 測試首頁所有ui事件
 * Created by Kevin on 2018/2/12.
 */
@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testClickDrawerLayout() throws Exception{
        //先暫停等待view載入完成防止 No views in hierarchy found matching: with id
        Thread.sleep(1000);
        // 測試打開側邊欄
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        //測試是否正確點擊成功
        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));
        //測試關閉側邊欄
        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close());
        //測試是否關閉成功
        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
        //測試搜尋按鈕
        Thread.sleep(1000);
        onView(withId(R.id.fab)).perform(click());
        //測試開啟action bar
        Thread.sleep(1000);
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        //測試關於的按鈕
        Thread.sleep(1000);
        onView(withText("提出建議")).perform(click());
    }
}
