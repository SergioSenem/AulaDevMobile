package com.sergio.devmobile.udesc.restmovies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<MovieView> movies;
    OnMovieClickListener onMovieClickListener;

    MovieAdapter(List<MovieView> movies, OnMovieClickListener onMovieClickListener) {
        this.movies = movies;
        this.onMovieClickListener = onMovieClickListener;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;

        MovieViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView)itemView.findViewById(R.id.movie_title);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieViewHolder mvh = new MovieViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder viewHolder, int i) {
        final MovieView m = this.movies.get(i);
        viewHolder.titleView.setText(movies.get(i).getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onMovieClickListener.onMovieClick(m);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
