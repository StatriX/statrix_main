import DbModels.DbKeywords;

import java.util.ArrayList;
import java.util.List;

public class DbKeywordsRepository implements KeywordsRepository {
    public List<DbKeywords> getKeywordsByPersonId(int personId) {
        //TODO: доделать получение ключевых слов из базы данных
        return new ArrayList<DbKeywords>();
    }
}
