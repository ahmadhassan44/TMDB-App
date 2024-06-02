package com.example.testtask.Activities;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testtask.Models.MovieVideoModel;
import com.example.testtask.R;
import com.example.testtask.Responses.MovieVideosResponse;
import com.example.testtask.Starters.ApiService;
import com.example.testtask.Starters.Constants;
import com.example.testtask.Starters.TMDBApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrailerActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        int movieid=getIntent().getIntExtra("movieid",-1);
        thetrailer(movieid);
    }
    void thetrailer(int movieid)
    {
        TMDBApi tmdbApi= ApiService.getTmdbApi();
        tmdbApi.getMovieTrailers(movieid,Constants.MY_KEY).enqueue(new Callback<MovieVideosResponse>() {
            @Override
            public void onResponse(Call<MovieVideosResponse> call, Response<MovieVideosResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MovieVideoModel> movieModels = response.body().getMovieVideos();
                    boolean flag=false;
                    for(MovieVideoModel m:movieModels)
                    {
                        if(m.getType().equals("Trailer") && movieModels.size()!=0)
                        {
                            webView=findViewById(R.id.webview);
                            WebSettings webSettings = webView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                            webSettings.setMediaPlaybackRequiresUserGesture(false);
                            webView.setWebViewClient(new WebViewClient());
                            String videoKey = m.getKey();
                            String videoUrl = "https://www.youtube.com/embed/" + videoKey+"?autoplay=1";
                            webView.loadUrl(videoUrl);
                            flag=true;
                            Log.d("aht"," trailer found");
                            break;
                        }
                    }
                    if(!flag)
                        Toast.makeText(TrailerActivity.this, "No Trailer Found", Toast.LENGTH_LONG).show();
            }
        }
        @Override
        public void onFailure(Call<MovieVideosResponse> call, Throwable throwable) {
            }
        });

    }
}