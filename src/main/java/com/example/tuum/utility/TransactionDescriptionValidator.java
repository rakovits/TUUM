package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionDescriptionException;

public class TransactionDescriptionValidator {
    public static void validateTransactionDescription(String transactionDescription) {
        if (transactionDescription.isEmpty()) {
            throw new InvalidTransactionDescriptionException("Transaction description can not be empty.");
        }
    }
}
