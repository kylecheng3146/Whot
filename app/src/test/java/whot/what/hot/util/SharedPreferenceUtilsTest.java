package whot.what.hot.util;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by Kevin on 2018/2/27.
 */
public class SharedPreferenceUtilsTest {

    private SharedPreferences sharedPrefs = Mockito.mock(SharedPreferences.class);
    private SharedPreferences.Editor mockedEditor = Mockito.mock(SharedPreferences.Editor.class);
    private Context context = Mockito.mock(Context.class);

    @Before
    public void setUp() throws Exception {
        this.sharedPrefs = Mockito.mock(SharedPreferences.class);
        this.mockedEditor = Mockito.mock(SharedPreferences.Editor.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs);
    }

    @Test
    public void setEmail() throws Exception {
        Mockito.when(sharedPrefs.edit()).thenReturn(mockedEditor);
        SharedPreferenceUtils.setEmail(context,"email");
        Mockito.verify(mockedEditor).apply();
    }

    @Test
    public void getEmail() throws Exception {
        Mockito.when(sharedPrefs.getString(anyString(), anyString())).thenReturn("email");
        Assert.assertEquals("email", SharedPreferenceUtils.getEmail(context));
    }

}
