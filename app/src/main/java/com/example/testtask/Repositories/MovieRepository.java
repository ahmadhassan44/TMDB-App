package com.example.testtask.Repositories;

import android.util.Log;

import com.example.testtask.Activities.MainActivity;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.Responses.MovieListResponse;
import com.example.testtask.RoomDatabase.DatabaseHelper;
import com.example.testtask.RoomDatabase.Movie;
import com.example.testtask.RoomDatabase.MovieDAO;
import com.example.testtask.Starters.ApiService;
import com.example.testtask.Starters.Constants;
import com.example.testtask.Starters.TMDBApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MovieDAO movieDAO;
    private TMDBApi tmdbApi;

    public MovieRepository() {

        DatabaseHelper db= MainActivity.database;
        movieDAO=db.movieDAO();
        tmdbApi= ApiService.getTmdbApi();
    }
    public void getUpcomingMoviesFromApiAndSaveToDb() {
        tmdbApi.getUpcomingMovies(Constants.MY_KEY, "en-US", 1).enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MovieListResponse> call, Response<MovieListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MovieModel> movieModels = response.body().getMovies();
                    insertMoviestoDB(movieModels);
                }
            }
            @Override
            public void onFailure(retrofit2.Call<MovieListResponse> call, Throwable throwable) {

            }
        });
    }
    private void insertMoviestoDB(List<MovieModel> movies)
    {
        List<Movie> dbmovies=new ArrayList<>();
        for(MovieModel model:movies)
        {
            Movie dbmovie = new Movie(model);
            dbmovies.add(dbmovie);
        }
        movieDAO.addUpcomingMovies(dbmovies);
    }

}
