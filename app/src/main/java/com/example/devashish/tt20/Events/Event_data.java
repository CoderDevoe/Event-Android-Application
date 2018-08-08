package com.example.devashish.tt20.Events;

/**
 * Created by Devashish on 12/7/2017.
 */

public class Event_data {
    private final int res;
    private final String Event_name;
    private final String regform_url;
    private final int Lay_resId;

    public Event_data(int res, String event_name, String regform_url, int lay_resId) {
        this.res = res;
        this.Event_name = event_name;
        this.regform_url = regform_url;
        Lay_resId = lay_resId;
    }

    public int getRes() {
        return res;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public String getRegform_url() {
        return regform_url;
    }

    public int getLay_resId() {
        return Lay_resId;
    }
}
