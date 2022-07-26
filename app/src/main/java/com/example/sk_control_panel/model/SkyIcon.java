package com.example.sk_control_panel.model;

import com.example.sk_control_panel.R;

import java.util.HashMap;
import java.util.Set;

public class SkyIcon {

    public static Sky getSkyIcon(String weather){
        HashMap<String,Sky> sky  = new HashMap<String,Sky>();
        sky.put("晴", new Sky("晴", R.drawable.ic_clear_day));
        sky.put("多云", new Sky("多云",R.drawable.ic_cloudy));
        sky.put("晴间多云", new Sky("晴间多云",R.drawable.ic_partly_cloud_day));
        sky.put("阴", new Sky("阴",R.drawable.ic_cloudy));
        sky.put("小雨", new Sky("小雨",R.drawable.ic_light_rain));
        sky.put("中雨", new Sky("中雨",R.drawable.ic_moderate_rain));
        sky.put("大雨", new Sky("大雨",R.drawable.ic_heavy_rain));
        sky.put("暴雨", new Sky("暴雨",R.drawable.ic_storm_rain));
        sky.put("大暴雨", new Sky("大暴雨",R.drawable.ic_storm_rain));
        sky.put("特大暴雨", new Sky("特大暴雨",R.drawable.ic_storm_rain));
        sky.put("阵雨", new Sky("阵雨",R.drawable.ic_storm_rain));
        sky.put("雷阵雨并伴有冰雹", new Sky("雷阵雨并伴有冰雹",R.drawable.ic_thunder_shower));
        sky.put("雨夹雪", new Sky("雨夹雪",R.drawable.ic_sleet));
        sky.put("雪", new Sky("小雪",R.drawable.ic_light_snow));
        sky.put("阵雪", new Sky("阵雪",R.drawable.ic_moderate_snow));
        sky.put("中雪", new Sky("中雪", R.drawable.ic_moderate_snow));
        sky.put("大雪", new Sky("阵雨",R.drawable.ic_heavy_snow));
        sky.put("暴雪", new Sky("暴雪",R.drawable.ic_heavy_snow));
        sky.put("霾", new Sky("轻度雾霾",R.drawable.ic_light_haze));
        sky.put("中度霾", new Sky("中度雾霾",R.drawable.ic_moderate_haze));
        sky.put("重度霾", new Sky("重度雾霾",R.drawable.ic_heavy_haze));
        sky.put("雾", new Sky("雾",R.drawable.ic_light_snow));
        sky.put("浓雾", new Sky("浓雾",R.drawable.ic_fog));
        sky.put("浮尘", new Sky("浮尘",R.drawable.ic_fog));
        sky.put("扬沙", new Sky("扬沙",R.drawable.ic_fog));
        sky.put("沙尘暴", new Sky("沙尘暴",R.drawable.ic_light_snow));
        sky.put("强沙尘暴", new Sky("强沙尘暴",R.drawable.ic_fog));

        Set<String> keySet = sky.keySet();//根据键值遍历集合
        for (String key:keySet){
            if (weather.equals(key)){
                return sky.get(key);//返回Sky对象
            }
        }
        return  new Sky("多云",R.drawable.ic_cloudy);
    }
}
