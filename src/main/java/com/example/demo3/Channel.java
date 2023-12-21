package com.example.demo3;

public class Channel {
    private String title;
    private String description;

    public void Channel() {
        this.title = "";
        this.description = "";
    }

    public void Channel(String title) {
        this.title = title;
    }

    public void Channel(String title, String description) {
        this.title = title;
        this.description = description;
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

/******************************
 CREATE TABLE `channels` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `title` (`title`),
 KEY `description` (`description`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
 *******************************/

