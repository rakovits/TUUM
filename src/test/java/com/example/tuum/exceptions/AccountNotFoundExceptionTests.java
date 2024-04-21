package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountNotFoundExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Account not found";
        AccountNotFoundException exception = new AccountNotFoundException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
