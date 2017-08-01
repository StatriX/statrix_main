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
        Thread checkSitesListFromDB = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        checkSitesListFromDB.setDaemon(true);
        checkSitesListFromDB.run();
    }

    private void runKeywordsCheckThread(){
        Thread checkKeywordsFromDB = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        checkKeywordsFromDB.setDaemon(true);
        checkKeywordsFromDB.run();
    }

    private void getCwrawlResult(){

    }
}