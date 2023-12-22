package com.example.demo3.model;

/******************************
 CREATE TABLE `users` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `is_auth` int(2) DEFAULT 0,
 `code` varchar(25) DEFAULT NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `login` (`login`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `password` (`password`),
 KEY `gender` (`gender`),
 KEY `is_auth` (`is_auth`),
 KEY `code` (`code`),
 KEY `phone` (`phone`),
 KEY `email` (`email`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
---------------
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
 --------------
 CREATE TABLE `credit_cards` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `account` int(25) NOT NULL,
 `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `amount` float(25) NOT NULL,
 `currency` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `fromaccount` int(25) NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `credit_card` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `account` (`account`),
 KEY `bank` (`bank`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `currency` (`currency`),
 KEY `fromaccount` (`fromaccount`),
 KEY `credit_card` (`credit_card`),
 KEY `phone` (`phone`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
 --------------
 CREATE TABLE `companies` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `channel_id` int(10) NOT NULL,
 `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `count_subscribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `speed_hour_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `speed_hour_to` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `is_views` int(2) NOT NULL DEFAULT 0,
 `procent_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `start_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `comments` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `title` (`title`),
 KEY `channel_id` (`channel_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
 *******************************/