package com.example.tuum.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountTests {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testId() {
        Long id = 1L;
        account.setId(id);
        assertEquals(id, account.getId());
    }

    @Test
    public void testCustomerId() {
        Long customerId = 123L;
        account.setCustomerId(customerId);
        assertEquals(customerId, account.getCustomerId());
    }

    @Test
    public void testCountry() {
        String country = "USA";
        account.setCountry(country);
        assertEquals(country, account.getCountry());
    }

    @Test
    public void testDefaultConstructor() {
        Account newAccount = new Account();
        assertNull(newAccount.getId());
        assertNull(newAccount.getCustomerId());
        assertNull(newAccount.getCountry());
    }

    @Test
    public void testParameterizedConstructor() {
        Long customerId = 123L;
        String country = "USA";
        Account newAccount = new Account(customerId, country);
        assertEquals(customerId, newAccount.getCustomerId());
        assertEquals(country, newAccount.getCountry());
    }
}
