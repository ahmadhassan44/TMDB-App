package com.example.testtask.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.testtask.Fragments.HomeFragment;
import com.example.testtask.Fragments.SearchFragment;
import com.example.testtask.Models.MovieModel;
import com.example.testtask.R;
import com.example.testtask.Repositories.MovieRepository;
import com.example.testtask.Responses.MovieListResponse;
import com.example.testtask.RoomDatabase.DatabaseHelper;
import com.example.testtask.Starters.ApiService;
import com.example.testtask.Starters.Constants;
import com.example.testtask.Starters.NetworkCheck;
import com.example.testtask.Starters.TMDBApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    public static DatabaseHelper database;
    public static TMDBApi tmdbApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=DatabaseHelper.getInstance(getApplicationContext());
        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        switchFragment(homeFragment, false);
        BottomNavigationView bottomNav = findViewById(R.id.bottomnav);


        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if(item.getItemId()==R.id.nav_home)
                    selectedFragment=homeFragment;
                else if (item.getItemId()==R.id.nav_search)
                    selectedFragment= new SearchFragment();
                switchFragment(selectedFragment,true);
                return true;
            }
        });
    }
    private void switchFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        if (addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }

}