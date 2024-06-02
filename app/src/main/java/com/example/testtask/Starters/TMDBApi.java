package com.example.testtask.Starters;

import com.example.testtask.Responses.MovieListResponse;
import com.example.testtask.Responses.MovieVideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBApi {

    @GET("movie/upcoming")
    Call<MovieListResponse> getUpcomingMovies(
            @Query("api_key") String apiKey,
            @Query("en-US") String language,
            @Query("page") int page
    );
    @GET("movie/{movie_id}/videos")
    Call<MovieVideosResponse> getMovieTrailers(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey
    );
}
