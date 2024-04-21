package com.example.tuum.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransactionTests {
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        transaction = new Transaction();
    }

    @Test
    public void testId() {
        Long id = 1L;
        transaction.setId(id);
        assertEquals(id, transaction.getId());
    }

    @Test
    public void testBalanceId() {
        Long balanceId = 123L;
        transaction.setBalanceId(balanceId);
        assertEquals(balanceId, transaction.getBalanceId());
    }

    @Test
    public void testTransactionAmount() {
        Double amount = 100.0;
        transaction.setTransactionAmount(amount);
        assertEquals(amount, transaction.getTransactionAmount());
    }

    @Test
    public void testDirectionOfTransaction() {
        String direction = "IN";
        transaction.setDirectionOfTransaction(direction);
        assertEquals(direction, transaction.getDirectionOfTransaction());
    }

    @Test
    public void testTransactionDescription() {
        String description = "Payment";
        transaction.setTransactionDescription(description);
        assertEquals(description, transaction.getTransactionDescription());
    }

    @Test
    public void testDefaultConstructor() {
        Transaction newTransaction = new Transaction();
        assertNull(newTransaction.getId());
        assertNull(newTransaction.getBalanceId());
        assertNull(newTransaction.getTransactionAmount());
        assertNull(newTransaction.getDirectionOfTransaction());
        assertNull(newTransaction.getTransactionDescription());
    }

    @Test
    public void testParameterizedConstructor() {
        Long balanceId = 123L;
        Double amount = 100.0;
        String direction = "IN";
        String description = "Payment";
        Transaction newTransaction = new Transaction(balanceId, amount, direction, description);
        assertEquals(balanceId, newTransaction.getBalanceId());
        assertEquals(amount, newTransaction.getTransactionAmount());
        assertEquals(direction, newTransaction.getDirectionOfTransaction());
        assertEquals(description, newTransaction.getTransactionDescription());
    }
}
