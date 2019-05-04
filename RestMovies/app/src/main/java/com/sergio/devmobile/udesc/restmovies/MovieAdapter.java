package com.sergio.devmobile.udesc.restmovies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> movies;

    MovieAdapter(List<Movie> movies){
        this.movies = movies;
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
        viewHolder.titleView.setText(movies.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
