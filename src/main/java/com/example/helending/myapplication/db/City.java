package com.example.helending.myapplication.db;

import org.litepal.crud.DataSupport;

/**
 * Created by helending on 24/04/2017.
 */

public class City extends DataSupport{
    private int id;

    private String cityName;

    private int stateId;

    private String weather;


    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
