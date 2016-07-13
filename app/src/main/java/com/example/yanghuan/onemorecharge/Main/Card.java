package com.example.yanghuan.onemorecharge.Main;

/**
 * Created by yanghuan on 2016/7/13.
 */
public class Card {
    private String place;
    private String time;
    private String connent;

    public Card(String name, String desc, String connent) {
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
}