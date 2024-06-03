package com.example.testtask.ViewModels;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testtask.Activities.MainActivity;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.Repositories.MovieRepository;
import com.example.testtask.RoomDatabase.DatabaseHelper;
import com.example.testtask.RoomDatabase.MovieDAO;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

public class SearchViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    @Mock
    private MovieRepository mockRepository;
    @Mock
    private DatabaseHelper mockDb;
    @Mock
    private MovieDAO mockMovieDAO;
    @Spy
    private List<MovieModel> mockMovies = new ArrayList<>();
    @Mock
    private MutableLiveData<List<MovieModel>> mockLiveData;
    private SearchViewModel viewModel;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MainActivity.database = mockDb;
        when(mockDb.movieDAO()).thenReturn(mockMovieDAO);
        viewModel = new SearchViewModel();
        viewModel.setMovieRepository(mockRepository);
        mockLiveData = new MutableLiveData<>();
    }
    @Test
    public void testSearchMovies_Success() {
        String query = "test query";
        when(mockRepository.searchMovieByName(query)).thenReturn(mockLiveData);
        LiveData<List<MovieModel>> searchResults = viewModel.searchMovies(query);
        verify(mockRepository).searchMovieByName(query);
        mockLiveData.setValue(mockMovies);
        assertEquals(mockLiveData, searchResults);
    }
}
