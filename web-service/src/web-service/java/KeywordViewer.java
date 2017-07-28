import java.util.List;

public class KeywordViewer {

    private KeywordsRepository iKeywordsRepository;

    public KeywordViewer(KeywordsRepository keywordsRepository) {
        iKeywordsRepository = keywordsRepository;
    }

    public void View(int personId) {
        List<DbKeywords> keywords = iKeywordsRepository.getKeywordsByPersonId(personId);
        for (DbKeywords k : keywords) {
            System.out.println(k.getName());
        }
    }
}
