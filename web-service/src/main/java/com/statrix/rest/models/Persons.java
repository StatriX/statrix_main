package com.statrix.rest.models;

public class Persons {
    private int id;
    private String name;

    public Persons(String name) {
        this.name = name;
    }

    public Persons(int id, String name) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }
}
