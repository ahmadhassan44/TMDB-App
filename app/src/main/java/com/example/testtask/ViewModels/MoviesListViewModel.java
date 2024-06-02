package com.example.testtask.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testtask.Models.MovieModel;
import com.example.testtask.Repositories.MovieRepository;
import com.example.testtask.RoomDatabase.Movie;

import java.util.List;

public class MoviesListViewModel extends ViewModel {

    private MovieRepository repository;
    private LiveData<List<Movie>> movies;
    MoviesListViewModel()
    {
        repository=new MovieRepository();
        movies=repository.getStoredMovies();
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }
    public void refreshMovies() {
        repository.refreshMoviesindb(1);
    }


}
