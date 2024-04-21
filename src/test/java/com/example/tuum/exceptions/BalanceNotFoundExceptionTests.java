package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceNotFoundExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Balance not found";
        BalanceNotFoundException exception = new BalanceNotFoundException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
