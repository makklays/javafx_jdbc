package com.example.demo3.model;

public class Channel {
    private Integer id;
    private String title;
    private String description;

    public Channel(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Channel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Channel(String title) {
        this.title = title;
    }

    public Channel() {
        this.title = "";
        this.description = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

