package com.example.demo3.dao;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "users", schema = "", catalog = "ai_bot_for_seo")
public class UserEntity {

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, insertable = true, updatable = true, length = 25)
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
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
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 25)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 10)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 25)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 25)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 25)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "is_auth", nullable = false, insertable = true, updatable = true)
    public boolean getIsAuth() {
        return isAuth;
    }
    public void setIsAuth(boolean isAuth) {
        this.isAuth = isAuth;
    }

    @Basic
    @Column(name = "code", nullable = true, insertable = true, updatable = true, length = 25)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "created_at", nullable = false, insertable = true, updatable = true, length = 20)
    public String getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    @Basic
    @Column(name = "updated_at", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUpdatedAt() {
        return updated_at;
    }
    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (isAuth != that.isAuth) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(login, that.login)) return false;
        if (!Objects.equals(firstname, that.firstname)) return false;
        if (!Objects.equals(lastname, that.lastname)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(gender, that.gender)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(code, that.code)) return false;
        if (!Objects.equals(created_at, that.created_at)) return false;
        return Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}

