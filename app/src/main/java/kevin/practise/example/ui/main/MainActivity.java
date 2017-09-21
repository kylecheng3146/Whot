package kevin.practise.example.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import kevin.practise.example.R;
import kevin.practise.example.api.ApiServices;
import kevin.practise.example.base.BaseActivity;
import kevin.practise.example.data.GankBean;
import kevin.practise.example.data.NotificationCountBean;
import kevin.practise.example.data.WeatherDataBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Retrofit retrofit;
    ApiServices api;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_retrofit_get)
    Button btnRetrofitGet;
    @BindView(R.id.btn_retrofit_get_gson)
    Button btnRetrofitGetGson;
    @BindView(R.id.btn_retrofit_get_dym)
    Button btnRetrofitGetDym;
    @BindView(R.id.btn_retrofit_parameter)
    Button btnRetrofitParameter;
    @BindView(R.id.btn_retrofit_combine)
    Button btnRetrofitCombine;
    @BindView(R.id.btn_retrofit_post)
    Button btnRetrofitPost;
    @BindView(R.id.btn_retrofit_rxjava)
    Button btnRetrofitRxjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnRetrofitGet.setOnClickListener(this);
        btnRetrofitGetGson.setOnClickListener(this);
        btnRetrofitGetDym.setOnClickListener(this);
        btnRetrofitParameter.setOnClickListener(this);
        btnRetrofitCombine.setOnClickListener(this);
        btnRetrofitPost.setOnClickListener(this);
        btnRetrofitRxjava.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_retrofit_get:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://gank.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);
                Call<ResponseBody> call = api.getAndroidInfo();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String result = response.body().string();
                            tvResult.setText(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.i("TAG", "@@@@@@@@");

                    }
                });

                break;
            case R.id.btn_retrofit_get_gson:
                api = retrofit.create(ApiServices.class);
                Call<GankBean> call_gson = api.getAndroidInfoWithGson();
                call_gson.enqueue(new Callback<GankBean>() {
                    @Override
                    public void onResponse(Call<GankBean> call, Response<GankBean> response) {
                        GankBean.ResultsBean bean = response.body().getResults().get(0);
                        tvResult.setText(
                                "_id:" + bean.get_id() + "\n"
                                        + "createdAt：" + bean.getCreatedAt() + "\n"
                                        + "desc：" + bean.getDesc() + "\n"
                                        + "images:" + bean.getImages() + "\n"
                                        + "publishedAt:" + bean.getPublishedAt() + "\n"
                                        + "source" + bean.getSource() + "\n"
                                        + "type:" + bean.getType() + "\n"
                                        + "url: " + bean.getUrl() + "\n"
                                        + "who:" + bean.getWho());
                    }

                    @Override
                    public void onFailure(Call<GankBean> call, Throwable t) {
                        Log.i("TAG", "@@@@@@@@");

                    }
                });
                break;

            case R.id.btn_retrofit_get_dym:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://op.juhe.cn/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                Call<WeatherDataBean> call_dym = api.getWeather("4ea58de8a7573377cec0046f5e2469d5");
                //异步
                call_dym.enqueue(new Callback<WeatherDataBean>() {
                    @Override
                    public void onResponse(Call<WeatherDataBean> call, Response<WeatherDataBean> response) {
                        String info = response.body().getResult().getData().getRealtime().getWeather().getInfo();
                        tvResult.setText("深圳天气：" + info);
                    }

                    @Override
                    public void onFailure(Call<WeatherDataBean> call, Throwable t) {
                        Log.i("TAG", "@@@@@@@@");

                    }
                });
                break;
            case R.id.btn_retrofit_parameter:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://gank.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                api.getAndroidInfoWithParameters(1).enqueue(new Callback<GankBean>() {
                    @Override
                    public void onResponse(Call<GankBean> call, Response<GankBean> response) {
                        tvResult.setText(response.body().getResults().get(0).getDesc());
                    }

                    @Override
                    public void onFailure(Call<GankBean> call, Throwable t) {

                    }
                });
                break;
            case R.id.btn_retrofit_combine:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://op.juhe.cn/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                Map<String, String> params = new HashMap<>();
                params.put("cityname", "深圳");
                params.put("key", "4ea58de8a7573377cec0046f5e2469d5");
                api.getWeatherWithParameters(params).enqueue(new Callback<WeatherDataBean>() {
                    @Override
                    public void onResponse(Call<WeatherDataBean> call, Response<WeatherDataBean> response) {
                        tvResult.setText(response.body().getResult().getData().getRealtime().getCity_name());
                    }

                    @Override
                    public void onFailure(Call<WeatherDataBean> call, Throwable t) {
                        Log.i("TAG", "@@@@@");
                    }
                });
                break;
            case R.id.btn_retrofit_post:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://211.22.242.13:8164")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                HashMap<String, String> hashmap = new HashMap<>();
                hashmap.put("IMEI", "355693063092533");
                hashmap.put("CusID", "0005967");
                hashmap.put("TimeStamp", "1497235728");
                hashmap.put("Signature", "ce42ccc9a6da004321c8f4dab7632c6b849245669634c155a9497afdc6fdfe11");
                hashmap.put("AppID", "20170518A");
                api.getNotificationCount("api/Android/NotifiListCount", hashmap).enqueue(new Callback<NotificationCountBean>() {
                    @Override
                    public void onResponse(Call<NotificationCountBean> call, Response<NotificationCountBean> response) {
                        Log.i("TAG", String.valueOf(response.body().getDataTable().get(0).getTotal()));
                        for (NotificationCountBean.DataTableBean bean : response.body().getDataTable()) {
                            Log.i("TAG", String.valueOf(bean.getTotal()));
                        }
                    }

                    @Override
                    public void onFailure(Call<NotificationCountBean> call, Throwable t) {

                    }
                });
                break;
            case R.id.btn_retrofit_rxjava:
                retrofit = new Retrofit.Builder()
                        .baseUrl("baseUrl")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                break;
        }
    }
}
