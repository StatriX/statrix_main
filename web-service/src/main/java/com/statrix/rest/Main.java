package com.statrix.rest;

import com.statrix.rest.service.KeywordViewer;
import com.statrix.rest.service.repository.FakeKeywordsRepository;

public class Main {
    public static void main(String[] args) {
        FakeKeywordsRepository repository = new FakeKeywordsRepository();
        KeywordViewer keywordViewer = new KeywordViewer(repository);
        keywordViewer.View(1);
    }
}
