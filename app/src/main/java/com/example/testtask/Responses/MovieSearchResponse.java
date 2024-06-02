package com.example.testtask.Responses;

import com.example.testtask.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieSearchResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<MovieModel> movies;
    public ArrayList<MovieModel> getMovies() {
        return movies;
    }
}
