package com.example.testtask.Starters;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit retrofit;
    private static TMDBApi tmdbApi;

    private ApiService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tmdbApi = retrofit.create(TMDBApi.class);
    }
    public static TMDBApi getTmdbApi() {
        if (tmdbApi == null)
            new ApiService();
        return tmdbApi;
    }
}
