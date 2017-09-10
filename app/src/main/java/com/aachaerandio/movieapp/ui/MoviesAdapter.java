package com.aachaerandio.movieapp.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aachaerandio.movieapp.R;
import com.aachaerandio.movieapp.model.Movie;
import com.aachaerandio.movieapp.service.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movie = movies.get(position);
        holder.title.setText(holder.movie.getTitle());
        Picasso.with(context)
                .load(ApiUtils.getPosterPath(holder.movie.getPosterPath()))
                .placeholder(R.color.colorAccent)
                .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.movie_title)
        TextView title;

        public Movie movie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
