package com.sergio.devmobile.udesc.restmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(int i = 0; i < 10; i++){
            Movie m = new Movie();
            m.setTitle(String.valueOf(i));
            movies.add(m);
        }

        MovieAdapter adapter = new MovieAdapter(movies);
        rv.setAdapter(adapter);
    }
}
