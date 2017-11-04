package whot.what.hot.api;

import java.util.HashMap;
import java.util.Map;

import whot.what.hot.data.AntModel;
import whot.what.hot.data.GankModel;
import whot.what.hot.data.MainModel;
import whot.what.hot.data.WeatherDataModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by sapido on 21/09/2017.
 */

public interface ApiServices {

    @GET("api/data/Android/10/1")
    Call<ResponseBody> getAndroidInfo();

    @GET("api/data/Android/10/1")
    Call<GankModel> getAndroidInfoWithGson();

    @GET("{fullUrl}")
    Observable<AntModel> getAntInfoWithGson(@Path(value = "fullUrl", encoded = true)  String fullUrl);


    @GET("onebox/weather/query?cityname=深圳")
    Call<WeatherDataModel> getWeather(@Query("key") String key);

    @GET("{fullUrl}")
    Observable<GankModel> getAndroidInfoWithParameters(@Path(value = "fullUrl", encoded = true)  String fullUrl);

    /*轉換URL把括號內刪除 並給入完整的URL即可*/
    @GET
    Observable<WeatherDataModel> getWeatherWithParameters(@Url String URL , @QueryMap Map<String, String> params);

    @POST("{page}")
    Call<MainModel> getNotificationCount(@Path("page") String page, @Body HashMap hashMap);

    @POST("{page}")
    Observable<MainModel> getNotificationCountWithRxJava(@Path("page") String page, @Body HashMap hashMap);

}
