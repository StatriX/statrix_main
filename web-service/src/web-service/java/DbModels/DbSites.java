package DbModels;

public class DbSites {
    private int id;
    private String name;
    private String url;

    // возможна иная логика получения значений из таблицы
    public DbSites(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
}
