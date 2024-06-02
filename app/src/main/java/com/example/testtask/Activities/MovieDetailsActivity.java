package com.example.testtask.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testtask.R;
import com.example.testtask.Repositories.MovieRepository;
import com.example.testtask.RoomDatabase.Movie;
import com.example.testtask.RoomDatabase.MovieDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MovieDetailsActivity extends AppCompatActivity {
    private int movieid;

    ImageView poster;
    TextView releasedate;
    TextView overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        poster=findViewById(R.id.imageView2);
        releasedate=findViewById(R.id.textView);
        overview=findViewById(R.id.textView5);
        movieid=getIntent().getIntExtra("movieid",-1);
        Movie movie=new MovieRepository().findMovieById(movieid);
        loadMovieDetailsIntoUi(movie);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TrailerActivity.class);
                intent.putExtra("movieid",movieid);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SelectSeatActivity.class);
                intent.putExtra("moviename",movie.getTitle());
                intent.putExtra("releasedate",movie.getRelease_date());
                startActivity(intent);
            }
        });
    }
    void loadMovieDetailsIntoUi(Movie movie){
        releasedate.setText("In Theatres "+formatDate(movie.getRelease_date(), "yyyy-MM-dd", "MMMM dd, yyyy"));
        overview.setText(movie.getOverview());
        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500"+movie.getPoster_path()).into(poster);
    }
    private String formatDate(String dateString, String currentFormat, String desiredFormat) {
        try {
            SimpleDateFormat currentDateFormat = new SimpleDateFormat(currentFormat, Locale.getDefault());
            SimpleDateFormat desiredDateFormat = new SimpleDateFormat(desiredFormat, Locale.getDefault());

            Date date = currentDateFormat.parse(dateString);
            return desiredDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}