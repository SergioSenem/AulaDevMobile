package com.sergio.devmobile.udesc.restmovies;

public class Director {
    private String id;
    private String name;

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}

//{"id":"nm0000033","name":"Alfred Hitchcock"},{"id":"nm0000080","name":"Orson Welles"}