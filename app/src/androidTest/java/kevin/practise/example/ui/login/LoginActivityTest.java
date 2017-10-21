package kevin.practise.example.ui.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kevin.practise.example.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Kevin on 19/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void testLoginClick() {
        // Type text and then press the button.
        onView(withId(R.id.et_mail))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.et_mail))
                .check(matches(withText("123")));


        onView(withId(R.id.et_password))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .check(matches(withText("1234")));


        onView(withId(R.id.btn_login))
                .perform(click());
    }

    @Test
    public void onPasswordEditorDone() throws Exception {

    }
}
