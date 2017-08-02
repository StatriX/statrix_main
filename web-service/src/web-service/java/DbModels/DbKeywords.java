package DbModels;

public class DbKeywords {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public DbKeywords(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
