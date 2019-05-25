package com.sergio.devmobile.udesc.restmovies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {

    private static String baseUrl = "http://10.0.2.2:8080/";

    private HttpService httpService;

    public DAO(){
        httpService = new HttpService();
    }

    public abstract String getRepository();

    public abstract JSONObject getJson(T object) throws JSONException;

    public abstract T getObject(JSONObject json) throws JSONException;

    public String getFullUrl(){
        return baseUrl + getRepository();
    }

    public List<T> getAll(){

        String path = this.getFullUrl();
        ArrayList<T> result = new ArrayList<T>();

        try{
            String response = this.httpService.get(path);
            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0; i < jsonArray.length(); i++){
                result.add(getObject(jsonArray.getJSONObject(i)));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return result;

    }

    public T getById(String id){
        String path = this.getFullUrl()+"/"+id;
        T item = null;
        try {
            String response = this.httpService.get(path);
            JSONObject itemJson = new JSONObject(response);
            item = this.getObject(itemJson);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }

    //POST
    public void add(T objectToSend){

        String path = this.getFullUrl();

        try {
            String json = getJson(objectToSend).toString();
            this.httpService.post(path, json);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void deleteById(String id){
        String path = this.getFullUrl() + "/" + id;

        try{
            this.httpService.delete(path);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
