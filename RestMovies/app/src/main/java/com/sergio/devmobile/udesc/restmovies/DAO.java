package com.sergio.devmobile.udesc.restmovies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class DAO<T> {

    private static String baseUrl = "http://localhost:8080";
    private URL url;
    private HttpURLConnection connection;

    public abstract String getRepository();

    public List<T> getAll(){

        StringBuffer content = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.url = new URL(baseUrl + "/" + getRepository());
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<T> result = null;
        try {
            result = mapper.readValue(content.toString(), new TypeReference<List<T>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
