package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidTransactionDirectionExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Invalid transaction direction";
        InvalidTransactionDirectionException exception = new InvalidTransactionDirectionException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
