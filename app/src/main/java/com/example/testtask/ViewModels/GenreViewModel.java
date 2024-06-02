package com.example.testtask.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testtask.Models.GenreModel;
import com.example.testtask.Repositories.MovieRepository;

import java.util.List;

public class GenreViewModel extends ViewModel {

    MovieRepository repository;
    GenreViewModel()
    {
        repository=new MovieRepository();
    }
    public LiveData<List<GenreModel>> getgenres()
    {
        return repository.getGenres();
    }
}
