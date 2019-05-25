package com.sergio.devmobile.udesc.restmovies;

import org.json.JSONException;
import org.json.JSONObject;

public class DAODirector extends DAO<Director> {

    @Override
    public String getRepository() {
        return "directors";
    }

    @Override
    public JSONObject getJson(Director object) throws JSONException {
        JSONObject json = new JSONObject();

        json.put("id", object.getId());
        json.put("name", object.getName());

        return json;
    }

    @Override
    public Director getObject(JSONObject json) throws JSONException {
        Director obj = new Director();

        obj.setId(json.getString("id"));
        if(json.has("name")){ obj.setName(json.getString("name")); }

        return obj;
    }
}
