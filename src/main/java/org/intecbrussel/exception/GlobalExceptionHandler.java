package org.intecbrussel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> HandleException(Exception exception){
        Map<String,Object> error = new HashMap<>();
        error.put("message", exception.getMessage());
        error.put("errorCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> HandleException(ResourceNotFoundException exception){
        Map<String,Object> error = new HashMap<>();
        error.put("message", exception.getMessage());
        error.put("errorCode", HttpStatus.NOT_FOUND.value());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
