package com.techmatrix.javafx_jdbc.model;

import com.techmatrix.javafx_jdbc.configuration.DbmsConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User
{
    private Integer id;
    private String login;
    private String firstname;
    private String lastname;
    private String password;
    private String gender;
    private String phone;
    private String email;
    private String city;
    private boolean isAuth;
    private String code;
    private String created_at;
    private String updated_at;

    public User(String login, String password, String firstname, String lastname, String gender, String phone, String email, String city, String code) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.code = code;
        this.created_at = now();
        this.updated_at = now();
    }

    public User(String login, String firstname, String lastname, String password, String gender, String phone, String email, String city) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.created_at = now();
        this.updated_at = now();
    }

    public User(String firstname, String lastname, String password, String gender, String phone, String email, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.created_at = now();
        this.updated_at = now();
    }

    // утилита для текущего времени
    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public boolean insertUser() {
        String sql = "INSERT INTO users (login, password, firstname, lastname, gender, phone, email, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DbmsConnection.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, this.login);
            stmt.setString(2, this.password); // TODO: зашифровать пароль
            stmt.setString(3, this.firstname);
            stmt.setString(4, this.lastname);
            stmt.setString(5, this.gender);
            stmt.setString(6, this.phone);
            stmt.setString(7, this.email);
            stmt.setString(8, this.created_at);
            stmt.setString(9, this.updated_at);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Пользователь добавлен: " + this.login);
                return true;
            } else {
                System.out.println("⚠️ Не удалось вставить пользователя: " + this.login);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean getAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        this.isAuth = auth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

