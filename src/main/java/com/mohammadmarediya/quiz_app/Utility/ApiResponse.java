package com.mohammadmarediya.quiz_app.Utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class ApiResponse<T> {

    private T data;
    private String message;

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ApiResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
