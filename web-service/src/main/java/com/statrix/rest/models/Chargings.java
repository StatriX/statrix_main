package com.statrix.rest.models;

public class Chargings {
    private int id;
    private String title;
    private short sitesCount;
    private short personsCount;
    private short usersCount;

    public Chargings(int id, String title, short sitesCount, short personsCount, short usersCount) {
        this.id = id;
        this.title = title;
        this.sitesCount = sitesCount;
        this.personsCount = personsCount;
        this.usersCount = usersCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public short getSitesCount() {
        return sitesCount;
    }

    public short getPersonsCount() {
        return personsCount;
    }

    public short getUsersCount() {
        return usersCount;
    }

}
