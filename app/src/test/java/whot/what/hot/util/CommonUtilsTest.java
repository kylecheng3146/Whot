package whot.what.hot.util;

import android.content.Context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

/** common utils test
 * Created by Kevin on 2018/3/1.
 */

@RunWith(RobolectricTestRunner.class)
public class CommonUtilsTest {

    private Context context = Mockito.mock(Context.class);

    @Before
    public void setUp() throws Exception {

        this.context = Mockito.mock(Context.class);
    }

    @Test
    public void showLoadingDialog() throws Exception {
    }

    @Test
    public void getDeviceId() throws Exception {
        Assert.assertEquals(null,CommonUtils.getDeviceId(context));
    }

    @Test
    public void isEmailValid() throws Exception {
        Assert.assertEquals(true,CommonUtils.isEmailValid("quickey123@gmail.com"));
    }

    @Test
    public void isPasswordValid() throws Exception {
        Assert.assertEquals(false,CommonUtils.isPasswordValid("1234"));
    }

    @Test
    public void loadJSONFromAsset() throws Exception {
    }

    @Test
    public void getTimeStamp() throws Exception {
        Assert.assertTrue(CommonUtils.getTimeStamp().length() != 0);
    }

    @Test
    public void intentActivity() throws Exception {
    }

    @Test
    public void initCipher() throws Exception {
    }

    @Test
    public void isLoggedIn() throws Exception {
    }

}
