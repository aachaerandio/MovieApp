package com.aachaerandio.movieapp.service;

import com.aachaerandio.movieapp.BuildConfig;
import com.aachaerandio.movieapp.model.MoviesResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TmdbApiService {

    public TmdbService getService() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TmdbService.class);
    }

    public interface TmdbService {
        @GET("3/discover/movie?language=en&sort_by=popularity.desc")
        Call<MoviesResult> popularMovies(@Query("api_key") String apiKey);

    }
}
