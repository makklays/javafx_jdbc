package com.example.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        this.created_at = "2023-12-06 20:50:00";
        this.updated_at = "2023-12-06 20:50:00";
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
        this.created_at = "2023-12-06 20:50:00";
        this.updated_at = "2023-12-06 20:50:00";
    }

    public User(String firstname, String lastname, String password, String gender, String phone, String email, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.created_at = "2023-12-06 20:50:00";
        this.updated_at = "2023-12-06 20:50:00";
    }

    public boolean insertUser()
    {
        try {
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
            // or
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            String sql1 = "INSERT INTO users (login, password, firstname, lastname, gender, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, this.login);
            stmt1.setString(2, this.password);
            stmt1.setString(3, this.firstname);
            stmt1.setString(4, this.lastname);
            stmt1.setString(5, this.gender);
            stmt1.setString(6, this.phone);
            stmt1.setString(7, this.email);

            int i = stmt1.executeUpdate();
            if (i > 0) {
                System.out.println("You was successfully inserted a new user");
            } else {
                System.out.println("Can't insert a new user in the database");
            }

            System.out.println("Loading driver...");

		    return true;

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
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
 *******************************/

