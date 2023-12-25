package com.example.demo3.dao;

import javax.persistence.*;
//import java.util.Date;

@Entity
@Table(name = "creditcards", schema = "", catalog = "ai_bot_for_seo")
public class CreditCardEntity {
    private int id;
    private int account;
    private String bank;
    private String firstname;
    private String lastname;
    private Float amount;
    private String currency;
    private int fromaccount;
    private String phone;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account", nullable = false, insertable = true, updatable = true)
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Basic
    @Column(name = "bank", nullable = true, insertable = true, updatable = true, length = 60)
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "firstname", nullable = false, insertable = true, updatable = true, length = 25)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, insertable = true, updatable = true, length = 25)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = true)
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "currency", nullable = false, insertable = true, updatable = true, length = 5)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "fromaccount", nullable = false, insertable = true, updatable = true)
    public int getFromaccount() {
        return fromaccount;
    }

    public void setFromaccount(int fromaccount) {
        this.fromaccount = fromaccount;
    }

    @Basic
    @Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}

