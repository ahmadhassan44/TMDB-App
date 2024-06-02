package com.example.testtask.Starters;

import com.example.testtask.Responses.GenreResponse;
import com.example.testtask.Responses.MovieListResponse;
import com.example.testtask.Responses.MovieSearchResponse;
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

    @GET("search/movie")
    Call<MovieSearchResponse> searchMovies(
            @Query("api_key") String apiKey,
            @Query("query") String query,
            @Query("page") int page
    );
    @GET("genre/movie/list")
    Call<GenreResponse> getGenres(
            @Query("api_key") String apiKey
    );
}
