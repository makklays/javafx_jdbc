package com.example.demo3;

public class Company {
    private Integer count_subscribe;
    private Integer speed_hour_from;
    private Integer speed_hour_to;
    private Integer id_country;
    private Integer is_views;
    private Integer procent_off;
    private String start_from;
    private String comments;

    public void Channel() {
        this.count_subscribe = 0;
        this.speed_hour_from = 0;
        this.speed_hour_to = 0;
        this.id_country = 0;
        this.is_views = 0;
        this.procent_off = 0;
        this.start_from = "";
        this.comments = "";
    }

    public void Channel(Integer count_subscribe, Integer speed_hour_from, Integer speed_hour_to, Integer id_country, Integer is_views, Integer procent_off, String start_from, String comments) {
        this.count_subscribe = count_subscribe;
        this.speed_hour_from = speed_hour_from;
        this.speed_hour_to = speed_hour_to;
        this.id_country = id_country;
        this.is_views = is_views;
        this.procent_off = procent_off;
        this.start_from = start_from;
        this.comments = comments;
    }

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

    public Integer getId_country() {
        return id_country;
    }

    public void setId_country(Integer id_country) {
        this.id_country = id_country;
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

