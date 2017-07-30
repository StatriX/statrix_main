import dao.DatabaseInerface;
import dao.MySQLDao;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static DatabaseInerface db = new MySQLDao();
    private static ConcurrentHashMap<String, String[]> keywords;
    private static Vector<String> sites;

    public static void main(String[] args) {

    }

    private void runSiteCheckThread(){

    }

    private void runKeywordsCheckThread(){

    }

    private void getCwrawlResult(){

    }

}
