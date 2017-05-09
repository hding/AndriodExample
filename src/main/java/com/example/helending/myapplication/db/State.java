package com.example.helending.myapplication.db;

import org.litepal.crud.DataSupport;

/**
 * Created by helending on 25/04/2017.
 */

public class State extends DataSupport {
    private int id;
    private String stateName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
