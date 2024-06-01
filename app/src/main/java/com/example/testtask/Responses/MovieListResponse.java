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
    @SerializedName("total_results")
    @Expose
    private int total_count;

    public int getTotal_count() {
        return total_count;
    }
    public ArrayList<MovieModel> getMovies() {
        return movies;
    }
}
