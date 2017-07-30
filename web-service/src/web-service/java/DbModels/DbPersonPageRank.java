package DbModels;

public class DbPersonPageRank {
    private int personId;
    private int pageId;
    private int rank;

    public DbPersonPageRank(int personId, int pageId) {
        this.personId = personId;
        this.pageId = pageId;
    }

    public int getRank() {
        return rank;
    }
}
