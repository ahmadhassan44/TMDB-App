package com.example.testtask.RoomDatabase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.testtask.Models.MovieModel;

@Entity(tableName = "movies")
public class Movie {
    @PrimaryKey
    private int id;
    @ColumnInfo(name="title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @ColumnInfo(name="poster_path")
    private String poster_path;
    @ColumnInfo(name="overview")
    private String overview;
    @ColumnInfo(name="backdrop_path")
    private String backdrop_path;

    @ColumnInfo(name="release_date")
    private String release_date;
    public Movie() {
    }
    public Movie(MovieModel model)
    {
            this.id=model.getId();
            this.overview=model.getOverview();
            this.backdrop_path=model.getBackdrop_path();
            this.poster_path=model.getPoster_path();
            this.title=model.getTitle();
            this.release_date=model.getRelease_date();

    }


}
