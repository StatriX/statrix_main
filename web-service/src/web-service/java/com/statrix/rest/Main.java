package com.statrix.rest;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        FakeKeywordsRepository repository = new FakeKeywordsRepository();
        KeywordViewer keywordViewer = new KeywordViewer(repository);
        keywordViewer.View(1);

        //get("/hello", (req, res) -> "Hello World");
    }
}
