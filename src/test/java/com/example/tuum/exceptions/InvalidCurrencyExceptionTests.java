package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidCurrencyExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Invalid currency";
        InvalidCurrencyException exception = new InvalidCurrencyException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
