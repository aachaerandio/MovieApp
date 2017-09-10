package com.aachaerandio.movieapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aachaerandio.movieapp.R;
import com.aachaerandio.movieapp.model.Movie;
import com.aachaerandio.movieapp.presenter.MoviesPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MoviesFragment extends Fragment implements MoviesPresenter.OnFinishedListener{

    @BindView(R.id.movies_recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;
    private MoviesPresenter moviesPresenter;
    private MoviesAdapter adapter;
    private List<Movie> movies = new ArrayList<>();

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MoviesAdapter(movies);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPresenter = new MoviesPresenter();
        moviesPresenter.loadMovies(this);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onFinished(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError() {

    }
}
