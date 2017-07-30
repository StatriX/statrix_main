import DbModels.DbKeywords;

import java.util.ArrayList;
import java.util.List;

public class DbKeywordsRepository implements KeywordsRepository {
    public List<DbKeywords> getKeywordsByPersonId(int personId) {
        //TODO: допилить получение списка ключевых слов из таблицы sx_keywords
        return new ArrayList<DbKeywords>();
    }
}
