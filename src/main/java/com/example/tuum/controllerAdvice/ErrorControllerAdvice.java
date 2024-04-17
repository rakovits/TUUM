package com.example.tuum.controllerAdvice;

import com.example.tuum.exceptions.InvalidResourceFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(InvalidResourceFieldException.class)
    public ResponseEntity<String> handleException(InvalidResourceFieldException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
    }
}
