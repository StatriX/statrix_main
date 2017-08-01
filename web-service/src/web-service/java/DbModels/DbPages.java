package DbModels;

import java.util.Date;

public class DbPages {
    private int id;
    private int siteId;
    private String url;
    private Date foundedDate;
    private Date lastScanDate;

    public DbPages(int siteId) {
        this.siteId = siteId;
    }

    public String getUrl() {
        return url;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public Date getLastScanDate() {
        return lastScanDate;
    }
}
