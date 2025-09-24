package com.techmatrix.javafx_jdbc.model;

public class Task {
    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private String status;

    public Task(Integer id, Integer userId, String title, String description, String status) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task(Integer id, Integer userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Task(Integer id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Task(Integer userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

