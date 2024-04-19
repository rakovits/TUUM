package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionDirectionException;

import java.util.List;

public class TransactionDirectionValidator {
    public static void validateTransactionDirection(String transactionDirection) {
        List<String> validTransactionDirections = List.of("IN", "OUT");

        if (!validTransactionDirections.contains(transactionDirection)) {
            throw new InvalidTransactionDirectionException("Invalid transaction direction: " + transactionDirection + ".");
        }
    }
}
