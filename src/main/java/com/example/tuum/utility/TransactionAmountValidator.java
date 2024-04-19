package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionAmountException;

public class TransactionAmountValidator {
    public static void validateTransactionAmount(Double transactionAmount) {
        if (transactionAmount < 0) {
            throw new InvalidTransactionAmountException("Invalid transaction amount: " + transactionAmount + ". Transaction amount can not be negative.");
        } else if (transactionAmount == 0) {
            throw new InvalidTransactionAmountException("Invalid transaction amount: " + transactionAmount + ". Transaction amount can not be zero.");
        } else if (!hasMaximumTwoDecimalPlaces(transactionAmount)) {
            throw new InvalidTransactionAmountException("Invalid transaction amount: " + transactionAmount + ". Transaction amount can not have more than two decimal places.");
        }

    }

    public static boolean hasMaximumTwoDecimalPlaces(Double amount) {
        String amountAsString = Double.toString(amount);

        return amountAsString.matches("^\\d+(?:\\.\\d{0,2})?$");
    }
}
