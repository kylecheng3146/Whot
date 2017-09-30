package kevin.practise.example.api;

import java.util.HashMap;
import java.util.Map;

import kevin.practise.example.data.AntBean;
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
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by sapido on 21/09/2017.
 */

public interface ApiServices {

//    @GET("macros/s/AKfycbxxgTSWXbEiX8EHBSWrt6PVDnMAfmM3FLYDAhy-cqgDTRVY6hA/exec")
//    @GET("somepath?keyword1=value1&keyword2=value2&keyword3=value3")
//    Call<ResponseBody> getAndroidInfo();

    @GET("api/data/Android/10/1")
    Call<ResponseBody> getAndroidInfo();

    @GET("api/data/Android/10/1")
    Call<GankBean> getAndroidInfoWithGson();

    @GET("macros/s/AKfycbxxgTSWXbEiX8EHBSWrt6PVDnMAfmM3FLYDAhy-cqgDTRVY6hA/exec")
    Call<AntBean> getAntInfoWithGson();


    @GET("onebox/weather/query?cityname=深圳")
    Call<WeatherDataBean> getWeather(@Query("key") String key);

    @GET("api/data/Android/10/{page}")
    Call<GankBean> getAndroidInfoWithParameters(@Path("page") int page);

    /*轉換URL把括號內刪除 並給入完整的URL即可*/
    @GET
    Observable<WeatherDataBean> getWeatherWithParameters(@Url String URL ,@QueryMap Map<String, String> params);

    @POST("{page}")
    Call<MainModel> getNotificationCount(@Path("page") String page, @Body HashMap hashMap);

    @POST("{page}")
    Observable<MainModel> getNotificationCountWithRxJava(@Path("page") String page, @Body HashMap hashMap);

}
