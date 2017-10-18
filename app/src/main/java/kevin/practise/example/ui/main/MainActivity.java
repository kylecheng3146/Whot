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
import butterknife.OnClick;
import kevin.practise.example.R;
import kevin.practise.example.api.ApiServices;
import kevin.practise.example.base.BaseActivity;
import kevin.practise.example.data.AntModel;
import kevin.practise.example.data.GankModel;
import kevin.practise.example.data.MainModel;
import kevin.practise.example.data.WeatherDataModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.util.Log.i;

public class MainActivity extends BaseActivity implements MainView,View.OnClickListener {


    @BindView(R.id.tv_result) TextView tvResult;
    @BindView(R.id.btn_retrofit_get) Button btnRetrofitGet;
    @BindView(R.id.btn_retrofit_get_gson) Button btnRetrofitGetGson;
    @BindView(R.id.btn_retrofit_get_dym) Button btnRetrofitGetDym;
    @BindView(R.id.btn_retrofit_parameter) Button btnRetrofitParameter;
    @BindView(R.id.btn_retrofit_combine) Button btnRetrofitCombine;
    @BindView(R.id.btn_retrofit_post) Button btnRetrofitPost;
    @BindView(R.id.btn_retrofit_rxjava) Button btnRetrofitRxjava;

    private MainPresenter presenter;
    HashMap<String, String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRetrofitGet.setOnClickListener(this);
        btnRetrofitGetGson.setOnClickListener(this);
        btnRetrofitGetDym.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_retrofit_get:
                Retrofit retrofit;
                ApiServices api;

                Retrofit retrofit1 = new Retrofit.Builder()
                        .baseUrl("http://gank.io/")
                        .build();

                ApiServices api1 = retrofit1.create(ApiServices.class);
                Call<ResponseBody> call = api1.getAndroidInfo();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String result = response.body().string();
                            Log.i("@@@", result);
                            tvResult.setText(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.i("TAG", "@@@@");
                    }
                });

                break;
            case R.id.btn_retrofit_get_gson:
//                retrofit = new Retrofit.Builder()
//                        .baseUrl("https://script.google.com/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                api = retrofit.create(ApiServices.class);
//                Call<AntModel> call_gson = api.getAntInfoWithGson();
//                call_gson.enqueue(new Callback<AntModel>() {
//                    @Override
//                    public void onResponse(Call<AntModel> call, Response<AntModel> response) {
//                        Log.i("TAG",response.body().getName() );
//                        tvResult.setText(response.body().getName());
//                    }
//
//                    @Override
//                    public void onFailure(Call<AntModel> call, Throwable t) {
//                        i("TAG", "@@@@@@@@");
//
//                    }
//                });
                break;

            case R.id.btn_retrofit_get_dym:
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://op.juhe.cn/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(ApiServices.class);

                Call<WeatherDataModel> call_dym = api.getWeather("4ea58de8a7573377cec0046f5e2469d5");
                //异步
                call_dym.enqueue(new Callback<WeatherDataModel>() {
                    @Override
                    public void onResponse(Call<WeatherDataModel> call, Response<WeatherDataModel> response) {
                        String info = response.body().getResult().getData().getRealtime().getWeather().getInfo();
                        tvResult.setText("深圳天氣：" + info);
                    }

                    @Override
                    public void onFailure(Call<WeatherDataModel> call, Throwable t) {
                        i("TAG", "@@@@@@@@");

                    }
                });
                break;
        }
    }

    @Override
    public void getNotificationData(MainModel bean) {
        tvResult.setText(bean.getResponse());
    }

    @Override
    public void getRetrofitPost(MainModel bean) {
        tvResult.setText(bean.getSqlDetail());
    }

    @Override
    public void getRetrofitParameter(GankModel bean) {
        tvResult.setText(bean.getResults().get(0).getDesc());
    }

    @Override
    public void getAntResult(AntModel bean) {

    }

    @OnClick(R.id.btn_retrofit_rxjava)
    @Override
    public void onRxJavaClick() {
        hashMap.put("IMEI", "355693063092533");
        hashMap.put("CusID", "0005967");
        hashMap.put("TimeStamp", "1497235728");
        hashMap.put("Signature", "ce42ccc9a6da004321c8f4dab7632c6b849245669634c155a9497afdc6fdfe11");
        hashMap.put("AppID", "20170518A");
        presenter = new MainPresenter(this);
        presenter.loadDataByRetrofitRxJava(hashMap);
        hashMap.clear();
    }

    @OnClick(R.id.btn_retrofit_post)
    @Override
    public void onRetrofitPostClick() {
        hashMap.put("IMEI", "355693063092533");
        hashMap.put("CusID", "0005967");
        hashMap.put("TimeStamp", "1497235728");
        hashMap.put("Signature", "ce42ccc9a6da004321c8f4dab7632c6b849245669634c155a9497afdc6fdfe11");
        hashMap.put("AppID", "20170518A");
        presenter = new MainPresenter(this);
        presenter.loadDataByRetrofitPost(hashMap);
        hashMap.clear();
    }

    @OnClick(R.id.btn_retrofit_combine)
    @Override
    public void onRetrofitCombineClick() {
        Map<String, String> map = new HashMap<>();
        map.put("cityname", "深圳");
        map.put("key", "4ea58de8a7573377cec0046f5e2469d5");
        presenter = new MainPresenter(this);
        presenter.loadDataByRetrofitCombine(map);
        hashMap.clear();
    }

    @OnClick(R.id.btn_retrofit_parameter)
    @Override
    public void onRetrofitParameterClick() {
        presenter = new MainPresenter(this);
        presenter.loadDataByRetrofitParameter();
    }

    @Override
    public void onRefreshView() {

    }
}
