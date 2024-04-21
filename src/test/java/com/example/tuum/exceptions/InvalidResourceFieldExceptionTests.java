package com.example.tuum.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidResourceFieldExceptionTests {
    @Test
    public void testErrorMessage() {
        String errorMessage = "Invalid resource field";
        InvalidResourceFieldException exception = new InvalidResourceFieldException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
