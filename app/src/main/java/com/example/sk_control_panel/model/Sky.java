package com.example.sk_control_panel.model;

public class Sky {

    private String info;

    private int icon;

    public Sky(String info,int icon){
        this.info = info;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public String getInfo() {
        return info;
    }
}
