package com.mohammadmarediya.quiz_app.DTOS;

public class UserResponseDto {



    private String email;
    private String token;

    public UserResponseDto(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public UserResponseDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
