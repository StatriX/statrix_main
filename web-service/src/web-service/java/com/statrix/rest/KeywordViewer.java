package com.statrix.rest;

import com.statrix.rest.models.Keywords;

import java.util.List;

public class KeywordViewer {

    private KeywordsRepository iKeywordsRepository;

    public KeywordViewer(KeywordsRepository keywordsRepository) {
        iKeywordsRepository = keywordsRepository;
    }

    public void View(int personId) {
        List<Keywords> keywords = iKeywordsRepository.getKeywordsByPersonId(personId);
        for (Keywords k : keywords) {
            System.out.println(k.getName());
        }
    }
}
