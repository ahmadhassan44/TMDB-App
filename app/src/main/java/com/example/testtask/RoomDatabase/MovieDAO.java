package com.example.testtask.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface MovieDAO {

    @Query("select * from movies")
    LiveData<List<Movie>> getAllUpcomingMovies();

    @Insert
    void addUpcomingMovies(List<Movie> list);

}
