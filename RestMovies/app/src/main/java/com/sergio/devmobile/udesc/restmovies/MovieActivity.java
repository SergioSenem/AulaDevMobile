package com.sergio.devmobile.udesc.restmovies;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    private MovieService service;
    private String movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        service = new MovieService();
        movieId = getIntent().getExtras().getString("movieId");
        LoadMovie load = new LoadMovie(movieId);
        load.execute();
    }

    public void DeleteMovie(View view){

        DeleteMovie deleteMovie = new DeleteMovie(movieId);
        deleteMovie.execute();

    }

    class LoadMovie extends AsyncTask<Void, Void, Movie> {

        private String movieId;

        LoadMovie(String movieId){
            super();
            this.movieId = movieId;
        }

        @Override
        protected Movie doInBackground(Void... voids) {
            Movie movie = service.getById(movieId);
            return movie;
        }

        @Override
        protected void onPostExecute(Movie movie){

            TextView title = findViewById(R.id.movieTitle);
            TextView duration = findViewById(R.id.movieDuration);
            TextView cost = findViewById(R.id.movieCost);
            TextView year = findViewById(R.id.movieYear);
            TextView currency = findViewById(R.id.movieCurrency);

            title.setText("Título: " + movie.getTitle());
            duration.setText("Duração: " + String.valueOf(movie.getDuration()));
            cost.setText("Preço: " + String.valueOf(movie.getCost()));
            year.setText("Ano: " + String.valueOf(movie.getYear()));
            currency.setText("Moeda: " + movie.getCurrency());

        }
    }

    class DeleteMovie extends AsyncTask<Void, Void, Void> {

        private String movieId;

        DeleteMovie(String movieId){
            super();
            this.movieId = movieId;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            service.deleteMovie(movieId);
            return null;
        }

        @Override
        protected void onPostExecute(Void voids){

            finish();

        }
    }
}
