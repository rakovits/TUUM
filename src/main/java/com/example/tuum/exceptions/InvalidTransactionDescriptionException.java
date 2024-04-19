package com.example.tuum.exceptions;

public class InvalidTransactionDescriptionException extends RuntimeException {
    public InvalidTransactionDescriptionException(String message) {
        super(message);
    }
}
