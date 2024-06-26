package com.example.testtask.Responses;

import androidx.annotation.NonNull;

import com.example.testtask.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieListResponse {


    @SerializedName("results")
    @Expose
    private ArrayList<MovieModel> movies;
    @SerializedName("total_pages")
    @Expose
    private int total_pages;

    public ArrayList<MovieModel> getMovies() {
        return movies;
    }
    public int getTotal_pages() {
        return total_pages;
    }

}
