package com.example.testtask.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testtask.Adapters.DateAdapter;
import com.example.testtask.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SelectSeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);
        TextView title=findViewById(R.id.textView8);
        TextView date=findViewById(R.id.textView9);
        title.setText(getIntent().getStringExtra("moviename"));
        date.setText("In Theatres "+formatDate(getIntent().getStringExtra("releasedate"), "yyyy-MM-dd", "MMMM dd, yyyy"));
        RecyclerView recyclerView=findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new DateAdapter());

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