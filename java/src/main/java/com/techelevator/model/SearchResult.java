package com.techelevator.model;

public class SearchResult {

    private Document[] docs;

    public Document[] getDocs() {
        return this.docs;
    }

    public void setDocs(Document[] docs) {
        this.docs = docs;
    }

    public SearchResult(){}

    public SearchResult(Document[] docs) {
        this.docs = docs;
    }
}
