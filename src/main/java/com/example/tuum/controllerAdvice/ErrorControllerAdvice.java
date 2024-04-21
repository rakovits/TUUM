package com.example.tuum.controllerAdvice;

import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(InvalidResourceFieldException.class)
    public ResponseEntity<String> handleInvalidResourceFieldException(InvalidResourceFieldException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage.message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage.message, HttpStatus.NOT_FOUND);
    }

    private record ErrorMessage(String message) {
    }
}
