package com.example.testtask.Responses;

import com.example.testtask.Models.MovieVideoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieVideosResponse  {
    @SerializedName("results")
    @Expose
    private ArrayList<MovieVideoModel> movieVideos;
    public ArrayList<MovieVideoModel> getMovieVideos() {
        return movieVideos;
    }
}
