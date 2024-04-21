package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidTransactionDescriptionExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Invalid transaction description";
        InvalidTransactionDescriptionException exception = new InvalidTransactionDescriptionException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
