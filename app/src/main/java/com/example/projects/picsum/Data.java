package com.example.projects.picsum;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("author")
    private String author;

    @SerializedName("id")
    private String id;

    public Data(String author, String id) {
        this.author = author;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
