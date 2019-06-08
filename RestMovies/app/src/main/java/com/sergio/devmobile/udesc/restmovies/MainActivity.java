package com.sergio.devmobile.udesc.restmovies;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener<MovieView> {

    private MovieService service;
    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new MovieService();
        LoadAllMovies load = new LoadAllMovies(this);
        load.execute();
    }

    @Override
    protected void onResume(){
        super.onResume();
        LoadAllMovies load = new LoadAllMovies(this);
        load.execute();
    }

    @Override
    public void onMovieClick(MovieView movie){
        Intent i = new Intent(MainActivity.this, MovieActivity.class);
        i.putExtra("movieId",movie.getId());
        startActivity(i);
    }

    class LoadAllMovies extends AsyncTask<Void, Void, ArrayList<MovieView>> {

        OnMovieClickListener onMovieClickListener;

        LoadAllMovies(OnMovieClickListener onMovieClickListener){
            super();
            this.onMovieClickListener = onMovieClickListener;
        }

        @Override
        protected ArrayList<MovieView> doInBackground(Void... voids) {
            ArrayList<MovieView> movies = service.getAll();
            return movies;
        }

        @Override
        protected void onPostExecute(ArrayList<MovieView> movies){

            list = findViewById(R.id.rv);

            RecyclerView.Adapter<MovieAdapter.MovieViewHolder> adapter = new MovieAdapter(movies, onMovieClickListener);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
            list.setLayoutManager(manager);
            list.setHasFixedSize(true);
            list.setAdapter(adapter);

        }
    }
}
