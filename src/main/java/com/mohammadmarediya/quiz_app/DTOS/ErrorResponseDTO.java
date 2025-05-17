package com.mohammadmarediya.quiz_app.DTOS;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseDTO {

    private String message;
    private LocalDateTime timeStamp;
    private HttpStatus status;

    public ErrorResponseDTO(String message, LocalDateTime timeStamp, HttpStatus status) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.status = status;
    }




}
