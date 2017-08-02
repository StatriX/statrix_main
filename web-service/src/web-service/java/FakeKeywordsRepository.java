import DbModels.DbKeywords;

import java.util.ArrayList;
import java.util.List;

public class FakeKeywordsRepository implements KeywordsRepository {
    public List<DbKeywords> getKeywordsByPersonId(int personId) {
        List<DbKeywords> keywords = new ArrayList<>();
        keywords.add(new DbKeywords(1, "Путин"));
        keywords.add(new DbKeywords(2, "Вовочка"));
        return keywords;
    }
}
