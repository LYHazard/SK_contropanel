package com.example.sk_control_panel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.sk_control_panel.gson.Weather;
import com.example.sk_control_panel.model.Sky;
import com.example.sk_control_panel.model.SkyIcon;
import com.example.sk_control_panel.model.Week;
import com.example.sk_control_panel.network.GetRequest_Interface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView Date;

    private TextClock clockText;

    private TextView placeName;

    private ImageView skyIcon;

    private TextView sky;

    private TextView currentTemp;

    private TextView week;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date = (TextView) findViewById(R.id.date);
        clockText = (TextClock) findViewById(R.id.clockInfo);
        placeName = (TextView) findViewById(R.id.placeName);
        skyIcon = (ImageView) findViewById(R.id.skyIcon);
        sky = (TextView) findViewById(R.id.Sky);
        currentTemp = (TextView) findViewById(R.id.currentTemp);
        week = (TextView) findViewById(R.id.week);
        requestWeather();

    }

    public void  requestWeather(){
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://app.skalarm.com:30010/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建网络请求接口实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);

        //对发送请求进行封装
        Call<Weather> call = request.getCall();

        //发送网络请求（异步）
        call.enqueue(new Callback<Weather>() {
            //请求成功
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                //处理返回数据结果
              if (response.body()!=null){
                  showWeatherInfo(response.body());
                  Log.d("MainActivity", response.body().data.city);
              }else {
                  Log.d("MainActivity", "未请求到任何信息");
              }
            }
            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showWeatherInfo(Weather weather) {
        //时间设置
        clockText.setTimeZone("GMT+8:00");
        //地点设置
        placeName.setText(weather.data.city);
        //日期设置
        Date.setText(weather.data.date);
        //天气文字显示
        sky.setText(weather.data.weather);
        //显示图标
        String skyicon =weather.data.weather;
        Sky sky = SkyIcon.getSkyIcon(skyicon);
        skyIcon.setImageResource(sky.getIcon());
        //显示星期
        String date = weather.data.week;
        String weekNum =Week.week(date);
        week.setText(weekNum);
        //显示当前温度
        String currentTempText = weather.data.temperature+"℃";
        currentTemp.setText(currentTempText);
    }
}