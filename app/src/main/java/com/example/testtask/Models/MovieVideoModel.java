package com.example.testtask.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieVideoModel  {

    private  String key;
    private String type;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    protected MovieVideoModel(Parcel in) {
        key = in.readString();
        type = in.readString();
    }
}
