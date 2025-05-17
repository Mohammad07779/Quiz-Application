package com.mohammadmarediya.quiz_app.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Table(name = "User")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String fname;

    private String lname;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String mobileNumber;

    private String password;

    private String Role;


    public Users() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(Integer userId, String fname, String lname, String email, String mobileNumber, String password, String role) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        Role = role;
    }
}
