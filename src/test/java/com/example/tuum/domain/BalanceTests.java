package com.example.tuum.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BalanceTests {
    private Balance balance;

    @BeforeEach
    public void setUp() {
        balance = new Balance();
    }

    @Test
    public void testId() {
        Long id = 1L;
        balance.setId(id);
        assertEquals(id, balance.getId());
    }

    @Test
    public void testAccountId() {
        Long accountId = 123L;
        balance.setAccountId(accountId);
        assertEquals(accountId, balance.getAccountId());
    }

    @Test
    public void testCurrency() {
        String currency = "USD";
        balance.setCurrency(currency);
        assertEquals(currency, balance.getCurrency());
    }

    @Test
    public void testAvailableAmount() {
        Double availableAmount = 1000.0;
        balance.setAvailableAmount(availableAmount);
        assertEquals(availableAmount, balance.getAvailableAmount());
    }

    @Test
    public void testDefaultConstructor() {
        Balance newBalance = new Balance();
        assertNull(newBalance.getId());
        assertNull(newBalance.getAccountId());
        assertNull(newBalance.getCurrency());
        assertNull(newBalance.getAvailableAmount());
    }

    @Test
    public void testParameterizedConstructor() {
        Long accountId = 123L;
        String currency = "USD";
        Double availableAmount = 1000.0;
        Balance newBalance = new Balance(accountId, currency, availableAmount);
        assertEquals(accountId, newBalance.getAccountId());
        assertEquals(currency, newBalance.getCurrency());
        assertEquals(availableAmount, newBalance.getAvailableAmount());
    }
}
