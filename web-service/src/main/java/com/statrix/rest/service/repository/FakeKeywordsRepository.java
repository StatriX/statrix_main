package com.statrix.rest.service.repository;

import com.statrix.rest.models.Keywords;

import java.util.ArrayList;
import java.util.List;

public class FakeKeywordsRepository implements KeywordsRepository {
    public List<Keywords> getKeywordsByPersonId(int personId) {
        List<Keywords> keywords = new ArrayList<>();
        keywords.add(new Keywords(1, "Путин"));
        keywords.add(new Keywords(2, "Вовочка"));
        return keywords;
    }
}
