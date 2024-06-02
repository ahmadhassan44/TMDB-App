package com.example.testtask.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieVideoModel implements Parcelable {

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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieVideoModel> CREATOR = new Creator<MovieVideoModel>() {
        @Override
        public MovieVideoModel createFromParcel(Parcel in) {
            return new MovieVideoModel(in);
        }

        @Override
        public MovieVideoModel[] newArray(int size) {
            return new MovieVideoModel[size];
        }
    };
}
