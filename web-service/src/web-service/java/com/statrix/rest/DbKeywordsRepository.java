package com.statrix.rest;

import com.statrix.rest.models.Keywords;

import java.util.ArrayList;
import java.util.List;

public class DbKeywordsRepository implements KeywordsRepository {
    public List<Keywords> getKeywordsByPersonId(int personId) {
        //TODO: доделать получение ключевых слов из базы данных
        return new ArrayList<Keywords>();
    }
}
