package com.example.tuum.controllerAdvice;

import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(InvalidResourceFieldException.class)
    public ResponseEntity<String> handleInvalidResourceFieldException(InvalidResourceFieldException e, WebRequest webRequest) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException e, WebRequest webRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
