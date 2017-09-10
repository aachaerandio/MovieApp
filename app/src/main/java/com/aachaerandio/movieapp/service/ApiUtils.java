package com.aachaerandio.movieapp.service;


public class ApiUtils {

    public static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";

    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }
}
