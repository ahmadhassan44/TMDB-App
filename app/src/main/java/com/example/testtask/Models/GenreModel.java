package com.example.testtask.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GenreModel implements Parcelable {
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected GenreModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<GenreModel> CREATOR = new Creator<GenreModel>() {
        @Override
        public GenreModel createFromParcel(Parcel in) {
            return new GenreModel(in);
        }

        @Override
        public GenreModel[] newArray(int size) {
            return new GenreModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
