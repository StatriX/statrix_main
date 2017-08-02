package com.statrix.rest.models;
// модель не нужна, страницы нужны только для краулера
import java.util.Date;

public class Pages {
    private int id;
    private int siteId;
    private String url;
    private Date foundedDate;
    private Date lastScanDate;

    public Pages(int siteId) {
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
