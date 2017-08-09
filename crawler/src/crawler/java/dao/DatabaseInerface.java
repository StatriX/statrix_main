package dao;

import entities.Keyword;
import entities.Site;

public interface DatabaseInerface {

    public Keyword[] getKeywords();
    public Site[] getSites();
    public void updateMatchCount();
    public void updateSiteURLs(Site site);
}
