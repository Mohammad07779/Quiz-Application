package com.mohammadmarediya.quiz_app.DTOS;

import jakarta.validation.constraints.*;

public class UserRequestDTO {

    private Integer userId;

    @NotBlank
    private String fname;

    @NotBlank
    private String lname;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format"
    )
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Size(max = 20, min = 8, message = "Password should be between 8 and 20 characters")
    private String password;

    private String Role;

    public UserRequestDTO(Integer userId, String fname, String lname, String email, String mobileNumber, String password, String role) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        Role = role;
    }

    public UserRequestDTO() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
