package com.example.testtask.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testtask.Models.MovieModel;
import com.example.testtask.Repositories.MovieRepository;

import java.util.List;

public class SearchViewModel extends ViewModel {
    private MovieRepository repository;
    SearchViewModel()
    {
        repository=new MovieRepository();
    }
    public LiveData<List<MovieModel>> searchMovies(String query) {
        return repository.searchMovieByName(query);
    }
    //this method is solely for testing purposes
    void setMovieRepository(MovieRepository repository) {
        this.repository = repository;
    }
}
