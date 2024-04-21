package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsufficientFundsExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Insufficient funds";
        InsufficientFundsException exception = new InsufficientFundsException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
