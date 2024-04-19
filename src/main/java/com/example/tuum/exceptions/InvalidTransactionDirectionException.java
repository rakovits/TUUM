package com.example.tuum.exceptions;

public class InvalidTransactionDirectionException extends RuntimeException {
    public InvalidTransactionDirectionException(String message) {
        super(message);
    }
}
