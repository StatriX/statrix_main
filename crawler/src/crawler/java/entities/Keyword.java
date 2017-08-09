package entities;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Keyword {

    private String keyword;
    private Set<String> subKeywordsSet = new TreeSet<>();

    public Keyword(String keyword, String ... subKeywords) {
        this.keyword = keyword;

        subKeywordsSet.addAll(Arrays.asList(subKeywords));
    }

    public String getKeyword() {
        return keyword;
    }

    public Set<String> getSubKeywordsSet() {
        return subKeywordsSet;
    }
}
