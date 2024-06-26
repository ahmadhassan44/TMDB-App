package com.example.testtask.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Movie.class,exportSchema = false,version = 2)

public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME="testtaskdb";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context)
    {
        if (instance==null)
            instance= Room.databaseBuilder(context,DatabaseHelper.class,DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        return instance;
    }
    public static DatabaseHelper getInstance()
    {
        return instance;
    }

    public abstract MovieDAO movieDAO();
}
