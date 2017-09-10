package com.aachaerandio.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoviesResult {

    @SerializedName("page")
    private Integer page;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("total_results")
    private Integer totalResults;
    @SerializedName("results")
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movies = movieList;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
