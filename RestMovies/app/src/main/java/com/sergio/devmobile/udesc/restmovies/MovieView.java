package com.sergio.devmobile.udesc.restmovies;

public class MovieView {
    private String id;
    private String title;

    public MovieView(){

    }

    public MovieView(String id, String title){
        this.id = id;
        this.title = title;
    }

    public MovieView(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
