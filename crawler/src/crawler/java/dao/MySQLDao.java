package dao;

import entities.Keyword;
import entities.Site;

public class MySQLDao implements DatabaseInerface {


    @Override
    public Keyword[] getKeywords() {
        return new Keyword[0];
    }

    @Override
    public Site[] getSites() {
        return new Site[0];
    }

    @Override
    public void updateMatchCount() {

    }

    @Override
    public void updateSiteURLs(Site site) {

    }
}
