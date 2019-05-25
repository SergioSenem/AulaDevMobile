package com.sergio.devmobile.udesc.restmovies;

import java.util.ArrayList;

public class MovieService {

    private DAOMovie dao;

    public MovieService() {
        dao = new DAOMovie();
    }

    public Movie getById(String id) {
        return dao.getById(id);
    }

    public ArrayList<MovieView> getAll(){

        ArrayList<MovieView> moviesView = new ArrayList<MovieView>();
        ArrayList<Movie> movies = new ArrayList<Movie>(dao.getAll());

        for(int i = 0; i < movies.size(); i++){
            moviesView.add(new MovieView(movies.get(i)));
        }

        return moviesView;
    }

    public void addMovie(Movie movie){
        dao.add(movie);
    }

    public void deleteMovie(String id){
        dao.deleteById(id);
    }

}
