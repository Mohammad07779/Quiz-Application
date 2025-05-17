package com.mohammadmarediya.quiz_app.Exception;

import com.mohammadmarediya.quiz_app.DTOS.ErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> DataIntegrityViolationExceptionhandler(DataIntegrityViolationException e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> ResourceNotFOundExceptionHandler(ResourceNotFoundException e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> ExceptionHandler(Exception e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
        return buidErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponseDTO> buidErrorMessage(String message, HttpStatus status) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(message, LocalDateTime.now(), status);
        return new ResponseEntity<>(errorResponseDTO, status);
    }
}
