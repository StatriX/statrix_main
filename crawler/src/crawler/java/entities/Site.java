package entities;

import java.util.Map;
import java.util.TreeMap;

public class Site {

    private String siteName;
    private Map<String, Integer> urlAndMatchCountMap = new TreeMap<>();

    public Site(String siteName, String ... urlName) {
        this.siteName = siteName;

        for (String str : urlName){
            urlAndMatchCountMap.put(str, 0);
        }
    }

    public String getSiteName() {
        return siteName;
    }

    public Map<String, Integer> getUrlAndMatchCountMap() {
        return urlAndMatchCountMap;
    }
}
