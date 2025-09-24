package com.techmatrix.javafx_jdbc.model;

public class Company {
    private Integer id;
    private Integer channel_id;
    private String title;
    private Integer count_subscribe;
    private Integer speed_hour_from;
    private Integer speed_hour_to;
    private Integer is_views;
    private Integer procent_off;
    private String start_from;
    private String comments;

    public Company(Integer id, String title, Integer channel_id, Integer count_subscribe, Integer speed_hour_from, Integer speed_hour_to) {
        this.id = id;
        this.title = title;
        this.channel_id = channel_id;
        this.count_subscribe = count_subscribe;
        this.speed_hour_from = speed_hour_from;
        this.speed_hour_to = speed_hour_to;
    }

    public void Company(String title, Integer channel_id, Integer count_subscribe, Integer speed_hour_from, Integer speed_hour_to, Integer is_views, Integer procent_off, String start_from, String comments) {
        this.title = title;
        this.channel_id = channel_id;
        this.count_subscribe = count_subscribe;
        this.speed_hour_from = speed_hour_from;
        this.speed_hour_to = speed_hour_to;
        this.is_views = is_views;
        this.procent_off = procent_off;
        this.start_from = start_from;
        this.comments = comments;
    }

    public void Company() {
        this.channel_id = 0;
        this.title = "";
        this.count_subscribe = 0;
        this.speed_hour_from = 0;
        this.speed_hour_to = 0;
        this.is_views = 0;
        this.procent_off = 0;
        this.start_from = "";
        this.comments = "";
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getChannel_id() { return channel_id; }

    public void setChannel_id(Integer channel_id) { this.channel_id = channel_id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Integer getCount_subscribe() {
        return count_subscribe;
    }

    public void setCount_subscribe(Integer count_subscribe) {
        this.count_subscribe = count_subscribe;
    }

    public Integer getSpeed_hour_from() {
        return speed_hour_from;
    }

    public void setSpeed_hour_from(Integer speed_hour_from) {
        this.speed_hour_from = speed_hour_from;
    }

    public Integer getSpeed_hour_to() {
        return speed_hour_to;
    }

    public void setSpeed_hour_to(Integer speed_hour_to) {
        this.speed_hour_to = speed_hour_to;
    }

    public Integer getIs_views() {
        return is_views;
    }

    public void setIs_views(Integer is_views) {
        this.is_views = is_views;
    }

    public Integer getProcent_off() {
        return procent_off;
    }

    public void setProcent_off(Integer procent_off) {
        this.procent_off = procent_off;
    }

    public String getStart_from() {
        return start_from;
    }

    public void setStart_from(String start_from) {
        this.start_from = start_from;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

