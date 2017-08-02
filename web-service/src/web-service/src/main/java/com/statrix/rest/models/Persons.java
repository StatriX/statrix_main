package com.statrix.rest.models;

public class Persons {
    private int id;
    private String name;

//    public Persons(int id) {
//        this.id = id;
//    }

    public Persons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
