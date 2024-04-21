package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidTransactionAmountExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Invalid transaction amount";
        InvalidTransactionAmountException exception = new InvalidTransactionAmountException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
