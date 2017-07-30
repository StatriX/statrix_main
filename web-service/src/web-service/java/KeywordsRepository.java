import DbModels.DbKeywords;

import java.util.List;

public interface KeywordsRepository {
    List<DbKeywords> getKeywordsByPersonId(int personId);
}
