package com.example.sk_control_panel.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Week {

    public static String week (String weather){
        HashMap<String,String> week  = new HashMap<String,String>();
        week.put("1","星期一");
        week.put("2","星期二");
        week.put("3","星期三");
        week.put("4","星期四");
        week.put("5","星期五");
        week.put("6","星期六");
        week.put("7","星期日");

        Set<String>keySet = week.keySet();
        for (String key:keySet){
            if (weather.equals(key)){
                return week.get(key);
            }
        }
        return "网络错误";
    }
}
