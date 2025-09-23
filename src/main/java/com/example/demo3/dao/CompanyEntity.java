package com.example.demo3.dao;

import javax.persistence.*;

@Entity
@Table(name = "companies", schema = "", catalog = "ai_bot_for_seo")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int channel_id;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private ChannelEntity channel;

    private String title;
    private int count_subscribe;
    private int speed_hour_from;
    private int speed_hour_to;
    private int is_views;
    private int procent_off;
    private String start_from;
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "channel_id", nullable = false, insertable = true, updatable = true)
    public int getChannelId() {
        return channel_id;
    }

    public void setChannelId(int channel_id) {
        this.channel_id = channel_id;
    }

    public ChannelEntity getChannel() { return channel; }
    public void setChannel(ChannelEntity channel) { this.channel = channel; }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 60)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "count_subscribe", nullable = false, insertable = true, updatable = true)
    public int getCountSubscribe() {
        return count_subscribe;
    }

    public void setCountSubscribe(int count_subscribe) {
        this.count_subscribe = count_subscribe;
    }

    @Basic
    @Column(name = "speed_hour_from", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourFrom() {
        return speed_hour_from;
    }

    public void setSpeedHourFrom(int speed_hour_from) {
        this.speed_hour_from = speed_hour_from;
    }

    @Basic
    @Column(name = "speed_hour_to", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourTo() {
        return speed_hour_to;
    }

    public void setSpeedHourTo(int speed_hour_to) {
        this.speed_hour_to = speed_hour_to;
    }

    @Basic
    @Column(name = "is_views", nullable = false, insertable = true, updatable = true)
    public int getIsViews() {
        return is_views;
    }

    public void setIsViews(int is_views) {
        this.is_views = is_views;
    }

    @Basic
    @Column(name = "procent_off", nullable = false, insertable = true, updatable = true)
    public int getProcentOff() {
        return procent_off;
    }

    public void setProcentOff(int procent_off) {
        this.procent_off = procent_off;
    }

    @Basic
    @Column(name = "start_from", nullable = false, insertable = true, updatable = true, length = 25)
    public String getStartFrom() {
        return start_from;
    }

    public void setStartFrom(String start_from) {
        this.start_from = start_from;
    }

    @Basic
    @Column(name = "comments", nullable = false, insertable = true, updatable = true, length = 500)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

