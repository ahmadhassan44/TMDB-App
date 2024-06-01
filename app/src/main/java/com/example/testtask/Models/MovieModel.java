package com.example.testtask.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Objects;

public class MovieModel implements Parcelable {
    private String  title;
    private String release_date;
    private String poster_path;
    private int id;
    private String overview;
    private String backdrop_path;
    private ArrayList<Objects> genres;



    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        id = in.readInt();
        overview = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<Objects> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Objects> genres) {
        this.genres = genres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public MovieModel(String title, String release_date, String poster_path, int id, String overview, String backdrop_path, ArrayList<Objects> genres) {
        this.title = title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.id = id;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.genres = genres;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeInt(id);
        dest.writeString(overview);
    }
}
