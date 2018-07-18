package com.sakshay.staggeredrecyclerview;

public class ItemObject {
    private String name;
    private String author;

    public ItemObject(String name, String auth) {
        this.name = name;
        this.author = auth;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
