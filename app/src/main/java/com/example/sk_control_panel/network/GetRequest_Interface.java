package com.example.sk_control_panel.network;

import com.example.sk_control_panel.gson.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest_Interface {
    @GET("sksys/api/v1/weather/weather-info?key=c0a05e81b7cd4566af7a26aa6c635e48")
    Call<Weather> getCall();
}
