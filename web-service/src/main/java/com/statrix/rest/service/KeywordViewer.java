package com.statrix.rest.service;

import com.statrix.rest.models.Keywords;
import com.statrix.rest.service.repository.KeywordsRepository;

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
