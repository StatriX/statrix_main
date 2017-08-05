package com.statrix.rest.models;

public class PersonPageRank {
    private int personId;
    private int pageId; // TODO: сделать siteId, чтобы не по каждой странице сайта статистика была, а по всему сайту
    private int rank;

    public PersonPageRank(int personId, int pageId, int rank) {
        this.personId = personId;
        this.pageId = pageId;
        this.rank = rank;
    }

    public int getPersonId() {
        return personId;
    }

    public int getPageId() {
        return pageId;
    }

    public int getRank() {
        return rank;
    }

}
