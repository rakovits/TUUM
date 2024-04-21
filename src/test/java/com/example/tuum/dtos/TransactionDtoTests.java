package com.example.tuum.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionDtoTests {
    @Test
    public void testTransactionId() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");

        Long newTransactionId = 789L;
        transactionDto.setTransactionId(newTransactionId);
        assertEquals(newTransactionId, transactionDto.getTransactionId());
    }

    @Test
    public void testAccountId() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");

        Long newAccountId = 999L;
        transactionDto.setAccountId(newAccountId);
        assertEquals(newAccountId, transactionDto.getAccountId());
    }

    @Test
    public void testTransactionAmount() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");


        Double newTransactionAmount = 200.0;
        transactionDto.setTransactionAmount(newTransactionAmount);
        assertEquals(newTransactionAmount, transactionDto.getTransactionAmount());
    }

    @Test
    public void testCurrency() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");

        String newCurrency = "EUR";
        transactionDto.setCurrency(newCurrency);
        assertEquals(newCurrency, transactionDto.getCurrency());
    }

    @Test
    public void testDirectionOfTransaction() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");

        String newDirectionOfTransaction = "OUT";
        transactionDto.setDirectionOfTransaction(newDirectionOfTransaction);
        assertEquals(newDirectionOfTransaction, transactionDto.getDirectionOfTransaction());
    }

    @Test
    public void testTransactionDescription() {
        TransactionDto transactionDto = new TransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment");

        String newTransactionDescription = "Refund";
        transactionDto.setTransactionDescription(newTransactionDescription);
        assertEquals(newTransactionDescription, transactionDto.getTransactionDescription());
    }
}
