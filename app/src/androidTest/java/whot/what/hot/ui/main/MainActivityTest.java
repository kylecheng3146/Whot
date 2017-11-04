package whot.what.hot.ui.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kevin.practise.hot.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Kevin on 19/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void onRxJavaClick() throws Exception {
        onView(withId(R.id.btn_retrofit_rxjava))
                .perform(click());
    }

    @Test
    public void onRetrofitPostClick() throws Exception {

    }

    @Test
    public void onRetrofitCombineClick() throws Exception {

    }

    @Test
    public void onRetrofitParameterClick() throws Exception {

    }

    @Test
    public void onRefreshView() throws Exception {

    }

}
