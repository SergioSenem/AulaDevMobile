package com.sergio.devmobile.udesc.restmovies;

import org.json.JSONException;
import org.json.JSONObject;

public class DAOMovie extends DAO<Movie>{
    @Override
    public String getRepository() {
        return "movies/";
    }

    @Override
    public JSONObject getJson(Movie object) throws JSONException {
        JSONObject json = new JSONObject();

        json.put("id", object.getId());
        json.put("title", object.getTitle());
        json.put("duration", object.getDuration());
        json.put("cost", object.getCost());
        json.put("year", object.getYear());
        json.put("director_id", object.getDirector_id());
        json.put("currency", object.getCurrency());

        return json;
    }

    @Override
    public Movie getObject(JSONObject obj) throws JSONException {
        Movie movie = new Movie();
        movie.setId(obj.getString("id"));
        if(obj.has("title")) movie.setTitle(obj.getString("title"));
        if(obj.has("duration")) movie.setDuration(obj.getInt("duration"));
        if(obj.has("cost")) movie.setCost(obj.getDouble("cost"));
        if(obj.has("year")) movie.setYear(obj.getInt("year"));
        if(obj.has("director_id")) movie.setDirector_id(obj.getInt("director_id"));
        if(obj.has("currency")) movie.setCurrency(obj.getString("currency"));
        return movie;
    }
}
