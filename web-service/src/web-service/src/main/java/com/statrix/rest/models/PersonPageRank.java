package com.statrix.rest.models;

public class PersonPageRank {
    private int personId;
    private int pageId;
    private int rank;

    public PersonPageRank(int personId, int pageId) {
        this.personId = personId;
        this.pageId = pageId;
    }

    public int getRank() {
        return rank;
    }
}
