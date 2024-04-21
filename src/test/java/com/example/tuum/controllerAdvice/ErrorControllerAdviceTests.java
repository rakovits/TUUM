package com.example.tuum.controllerAdvice;

import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorControllerAdviceTests {
    @Test
    public void testHandleInvalidResourceFieldException() {
        ErrorControllerAdvice errorControllerAdvice = new ErrorControllerAdvice();
        InvalidResourceFieldException exception = new InvalidResourceFieldException("Invalid field");

        ResponseEntity<String> responseEntity = errorControllerAdvice.handleInvalidResourceFieldException(exception);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals("Invalid field", responseEntity.getBody());
    }

    @Test
    public void testHandleAccountNotFoundException() {
        ErrorControllerAdvice errorControllerAdvice = new ErrorControllerAdvice();
        AccountNotFoundException exception = new AccountNotFoundException("Account not found");

        ResponseEntity<String> responseEntity = errorControllerAdvice.handleAccountNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Account not found", responseEntity.getBody());
    }
}
