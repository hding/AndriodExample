package com.example.helending.myapplication.util;

import android.text.TextUtils;

import com.example.helending.myapplication.db.City;
import com.example.helending.myapplication.db.State;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by helending on 24/04/2017.
 */

public class Utility {

    public static void sendRequest(String url, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);

    }


    public static void handleResponse(String response){
        if(!TextUtils.isEmpty(response)){
            City city =new City();
            city.setCityName("");
            city.save();

        }
    }
    //http://www.bom.gov.au/catalogue/data-feeds.shtml

    public static void initializeStateCity(){
        State state1 = new State();
        state1.setStateName("New South Wales/Australian Capital Territory");
        state1.setId(1);
        state1.save();

        City city1 = new City();
        city1.setCityName("Canberra");
        city1.setStateId(1);
        city1.save();

        City city2 = new City();
        city2.setCityName("Sydney");
        city2.setStateId(1);
        city2.save();

        City city3 = new City();
        city3.setCityName("Wolloogong");
        city3.setStateId(1);
        city3.save();



        State state2 = new State();
        state2.setStateName("Victoria");
        state2.setId(2);
        state2.save();

        City city21 = new City();
        city21.setCityName("Melbourn");
        city21.setStateId(2);
        city21.save();

        State state3 = new State();
        state3.setStateName("Norther Territory");
        state3.setId(3);
        state3.save();

        City city31 = new City();
        city31.setCityName("Alice Spring");
        city31.setStateId(3);
        city31.save();

        State state4 = new State();
        state4.setStateName("Queensland");
        state4.setId(4);
        state4.save();

        City city41 = new City();
        city41.setCityName("Brisbane");
        city41.setStateId(4);
        city41.save();

        City city42 = new City();
        city42.setCityName("Gold coaste");
        city42.setStateId(4);
        city42.save();


        State state5 = new State();
        state5.setStateName("South Australia");
        state5.setId(5);
        state5.save();

        City city51 = new City();
        city51.setCityName("Adlaide");
        city51.setStateId(5);
        city51.save();

    }




}
