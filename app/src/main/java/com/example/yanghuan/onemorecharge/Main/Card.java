package com.example.yanghuan.onemorecharge.Main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.yanghuan.onemorecharge.R;

import java.util.List;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class Card {
    private String place;
    private String time;
    private String connent;
    private String url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";

    public Card(String name, String desc, String connent, Context context) {
        this.place = place;
        this.time = time;
        this.connent = connent;

    }

    public String getplace() {
        return place;
    }
    public void settime(String time) {
        this.time = time;
    }
    public String gettime() {
        return time;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getConnent() {
        return connent;
    }
    public void setConnent(String connent) {
        this.connent = connent;
    }
    public String getURL() {
        return url;
    }
}