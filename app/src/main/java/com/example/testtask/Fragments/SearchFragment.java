package com.example.testtask.Fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.testtask.Adapters.GenreAdapter;
import com.example.testtask.Adapters.SearchAdapter;
import com.example.testtask.Models.GenreModel;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.R;
import com.example.testtask.ViewModels.GenreViewModel;
import com.example.testtask.ViewModels.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    View searchFragment;
    SearchView searchView;
    RecyclerView recyclerView;
    SearchViewModel searchViewModel;
    GenreViewModel genreViewModel;


    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         searchFragment=inflater.inflate(R.layout.fragment_search, container, false);
         return searchFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchView=searchFragment.findViewById(R.id.searchView);
        recyclerView=searchFragment.findViewById(R.id.recview);
        searchViewModel=new ViewModelProvider(this).get(SearchViewModel.class);
        genreViewModel=new ViewModelProvider(this).get(GenreViewModel.class);
        GenreAdapter genreAdapter=new GenreAdapter(new ArrayList<>());
        SearchAdapter searchAdapter=new SearchAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(genreAdapter);
        genreViewModel.getgenres().observe(getViewLifecycleOwner(), new Observer<List<GenreModel>>() {
            @Override
            public void onChanged(List<GenreModel> genreModels) {
                genreAdapter.setGenres(genreModels);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty())
                {
                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),2));
                    recyclerView.setAdapter(genreAdapter);
                }
                else {
                    searchViewModel.searchMovies(newText).observe(getViewLifecycleOwner(), new Observer<List<MovieModel>>() {
                        @Override
                        public void onChanged(List<MovieModel> movieModels) {
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            searchAdapter.setSearchResults(movieModels);
                            recyclerView.setAdapter(searchAdapter);
                        }
                    });
                }
                return false;
            }
        });
    }

}