package kevin.practise.example.api;

import java.util.HashMap;
import java.util.Map;

import kevin.practise.example.data.GankBean;
import kevin.practise.example.data.MainModel;
import kevin.practise.example.data.WeatherDataBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by sapido on 21/09/2017.
 */

public interface ApiServices {

    @GET("api/data/Android/10/1")
    Call<ResponseBody> getAndroidInfo();

    @GET("api/data/Android/10/1")
    Call<GankBean> getAndroidInfoWithGson();

    @GET("onebox/weather/query?cityname=深圳")
    Call<WeatherDataBean> getWeather(@Query("key") String key);

    @GET("api/data/Android/10/{page}")
    Call<GankBean> getAndroidInfoWithParameters(@Path("page") int page);

    @GET("onebox/weather/query?")
    Call<WeatherDataBean> getWeatherWithParameters(@QueryMap Map<String, String> params);

    @POST("{page}")
    Call<MainModel> getNotificationCount(@Path("page") String page, @Body HashMap hashMap);

    @POST("{page}")
    Observable<MainModel> getNotificationCountWithRxJava(@Path("page") String page, @Body HashMap hashMap);

}
