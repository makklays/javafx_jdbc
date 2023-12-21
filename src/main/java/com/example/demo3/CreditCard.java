package com.example.demo3;

public class CreditCard {
    private Integer account;
    private String bank;
    private String firstname;
    private String lastname;
    private Float amount;
    private String currency;
    private Integer fromaccount;
    private String phone;

    public CreditCard() {
        this.account = 1;
        this.bank = "";
        this.firstname = "";
        this.lastname = "";
        this.amount = 1F;
        this.currency = "";
        this.fromaccount = 111111;
        this.phone = "";
    }

    public CreditCard(Integer account, String bank) {
        this.account = account;
        this.bank = bank;
    }

    public CreditCard(Integer account, String bank, String firstname, String lastname) {
        this.account = account;
        this.bank = bank;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public CreditCard(Integer account, String bank, String firstname, String lastname, Float amount, String currency, Integer fromacc, String phone) {
        this.account = account;
        this.bank = bank;
        this.firstname = firstname;
        this.lastname = lastname;
        this.amount = amount;
        this.currency = currency;
        this.fromaccount = fromacc;
        this.phone = phone;
    }

    public String getInfo() {
        return this.account + " " + this.bank + " " + this.firstname + " " + this.lastname +" "+ this.amount + " " + this.currency + " ==>" + this.fromaccount + "<== " + this.phone;
    }

    public Integer getAccount() {
        return this.account;
    }
    public void setAccount(Integer acc) {
        this.account = acc;
    }

    public String getBank() {
        return this.bank;
    }
    public void setBank(String bnk) {
        this.bank = bnk;
    }

    public String getFirstname() {
        return this.firstname;
    }
    public void setFirstname(String fname) {
        this.firstname = fname;
    }

    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String lname) {
        this.lastname = lname;
    }

    public Float getAmount() {
        return this.amount;
    }
    public void setAmount(Float amnt) {
        this.amount = amnt;
    }

    public String getCurrency() {
        return this.currency;
    }
    public void setCurrency(String curr) {
        this.currency = curr;
    }

    public Integer getFromaccount() {
        return this.fromaccount;
    }
    public void setFromaccount(Integer fromaccn) {
        this.fromaccount = fromaccn;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String pho) {
        this.phone = pho;
    }
}

/******************************
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
 *******************************/

