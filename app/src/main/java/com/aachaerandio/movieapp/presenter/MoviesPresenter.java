package com.aachaerandio.movieapp.presenter;

import android.support.annotation.NonNull;

import com.aachaerandio.movieapp.BuildConfig;
import com.aachaerandio.movieapp.model.Movie;
import com.aachaerandio.movieapp.model.MoviesResult;
import com.aachaerandio.movieapp.service.TmdbApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesPresenter {

    private TmdbApiService tmdbApiService;

    public void loadMovies(final OnFinishedListener listener) {
        tmdbApiService = new TmdbApiService();

        tmdbApiService.getService().popularMovies(BuildConfig.TMDB_API_KEY)
                .enqueue(new Callback<MoviesResult>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviesResult> call, @NonNull Response<MoviesResult> response) {
                        if (response.body() != null && response.body().getMovieList() != null) {
                            listener.onFinished(response.body().getMovieList());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MoviesResult> call, Throwable t) {
                        listener.onError();
                    }
                });
    }

    public interface OnFinishedListener {
        void onFinished(List<Movie> items);
        void onError();

    }
}
