package com.statrix.rest;
import com.statrix.rest.FakeKeywordsRepository;
import com.statrix.rest.KeywordViewer;

public class Main {
    public static void main(String[] args) {
        FakeKeywordsRepository repository = new FakeKeywordsRepository();
        KeywordViewer keywordViewer = new KeywordViewer(repository);
        keywordViewer.View(1);
    }
}
