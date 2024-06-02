package com.example.testtask.Responses;

import com.example.testtask.Models.GenreModel;
import com.example.testtask.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GenreResponse {
    @SerializedName("genres")
    @Expose
    private ArrayList<GenreModel> genres;
    public ArrayList<GenreModel> getGenres() {
        return genres;
    }
}
