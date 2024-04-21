package com.example.tuum.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTransactionDtoTests {
    @Test
    public void testTransactionId() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        Long newTransactionId = 789L;
        createTransactionDto.setTransactionId(newTransactionId);
        assertEquals(newTransactionId, createTransactionDto.getTransactionId());
    }

    @Test
    public void testAccountId() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        Long newAccountId = 999L;
        createTransactionDto.setAccountId(newAccountId);
        assertEquals(newAccountId, createTransactionDto.getAccountId());
    }

    @Test
    public void testTransactionAmount() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        Double newTransactionAmount = 200.0;
        createTransactionDto.setTransactionAmount(newTransactionAmount);
        assertEquals(newTransactionAmount, createTransactionDto.getTransactionAmount());
    }

    @Test
    public void testCurrency() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        String newCurrency = "EUR";
        createTransactionDto.setCurrency(newCurrency);
        assertEquals(newCurrency, createTransactionDto.getCurrency());
    }

    @Test
    public void testDirectionOfTransaction() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        String newDirectionOfTransaction = "OUT";
        createTransactionDto.setDirectionOfTransaction(newDirectionOfTransaction);
        assertEquals(newDirectionOfTransaction, createTransactionDto.getDirectionOfTransaction());
    }

    @Test
    public void testTransactionDescription() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        String newTransactionDescription = "Refund";
        createTransactionDto.setTransactionDescription(newTransactionDescription);
        assertEquals(newTransactionDescription, createTransactionDto.getTransactionDescription());
    }

    @Test
    public void testAvailableAmountAfterTransaction() {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto(123L, 456L, 100.0, "USD", "IN", "Payment", 50.0);

        Double newAvailableAmountAfterTransaction = 75.0;
        createTransactionDto.setAvailableAmountAfterTransaction(newAvailableAmountAfterTransaction);
        assertEquals(newAvailableAmountAfterTransaction, createTransactionDto.getAvailableAmountAfterTransaction());
    }
}
