package com.aachaerandio.movieapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aachaerandio.movieapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MoviesFragment extends Fragment {

    @BindView(R.id.movies_recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        return rootView;
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }
}
