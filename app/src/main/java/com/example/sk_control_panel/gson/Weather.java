package com.example.sk_control_panel.gson;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("errMsg")
    public String status;

    public Data data;

    public void show(){
        System.out.printf(status);
    }

}
