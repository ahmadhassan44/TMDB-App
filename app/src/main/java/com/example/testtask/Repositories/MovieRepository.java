package com.example.testtask.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testtask.Activities.MainActivity;
import com.example.testtask.Models.GenreModel;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.Responses.GenreResponse;
import com.example.testtask.Responses.MovieListResponse;
import com.example.testtask.Responses.MovieSearchResponse;
import com.example.testtask.RoomDatabase.DatabaseHelper;
import com.example.testtask.RoomDatabase.Movie;
import com.example.testtask.RoomDatabase.MovieDAO;
import com.example.testtask.Starters.ApiService;
import com.example.testtask.Starters.Constants;
import com.example.testtask.Starters.TMDBApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
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
    public void refreshdb()
    {
        movieDAO.deleteAllMovies();
        refreshMoviesindb(1);
    }
    public void refreshMoviesindb(int start) {
        final int START=start;
        tmdbApi.getUpcomingMovies(Constants.MY_KEY, "en-US",START).enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MovieListResponse> call, Response<MovieListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MovieModel> movieModels = response.body().getMovies();
                    List<Movie> dbmovies=new ArrayList<>();
                    for(MovieModel model:movieModels)
                    {
                        Movie dbmovie = new Movie(model);
                        dbmovies.add(dbmovie);
                    }
                    if(START<=response.body().getTotal_pages())
                        refreshMoviesindb(START+1);
                    movieDAO.addUpcomingMovies(dbmovies);
                }
            }
            @Override
            public void onFailure(retrofit2.Call<MovieListResponse> call, Throwable throwable) {

            }
        });
    }
    public LiveData<List<Movie>> getStoredMovies()
    {
        return movieDAO.getAllUpcomingMovies();
    }
    public Movie findMovieById(int id)
    {
        return movieDAO.findMovieById(id);
    }
    public LiveData<List<MovieModel>> searchMovieByName(String query) {
        final MutableLiveData<List<MovieModel>> searchResults = new MutableLiveData<>();
        tmdbApi.searchMovies(Constants.MY_KEY,query,1).enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MovieModel> movies = response.body().getMovies();
                    searchResults.setValue(movies);
                }
            }
            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable throwable) {
            }
        });
        return searchResults;
    }
    public LiveData<List<GenreModel>> getGenres()
    {
        final MutableLiveData<List<GenreModel>> genreResults = new MutableLiveData<>();
        tmdbApi.getGenres(Constants.MY_KEY).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                if(response.isSuccessful() && response.body() != null)
                    genreResults.setValue(response.body().getGenres());

            }
            @Override
            public void onFailure(Call<GenreResponse> call, Throwable throwable) {

            }
        });
        return genreResults;
    }

}
