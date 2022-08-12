package com.techelevator.model;

public class Document {

    private String key;
    private String title;
    private String[] author_name;

    public String[] getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String[] author_name) {
        this.author_name = author_name;
    }

    public Document(String key, String title, String[] author_name) {
        this.key = key;
        this.title = title;
        this.author_name = author_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Document(){}


}
