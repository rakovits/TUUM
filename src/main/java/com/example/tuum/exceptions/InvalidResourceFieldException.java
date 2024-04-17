package com.example.tuum.exceptions;

public class InvalidResourceFieldException extends RuntimeException {
    public InvalidResourceFieldException(String message) {
        super(message);
    }
}
