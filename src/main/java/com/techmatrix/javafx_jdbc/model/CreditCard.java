package com.techmatrix.javafx_jdbc.model;

public class CreditCard {
    private Integer id;
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
        return this.id + " " + this.account + " " + this.bank + " " + this.firstname + " " + this.lastname +" "+ this.amount + " " + this.currency + " ==>" + this.fromaccount + "<== " + this.phone;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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

