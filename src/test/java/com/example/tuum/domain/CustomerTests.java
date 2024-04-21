package com.example.tuum.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CustomerTests {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testId() {
        Long id = 1L;
        customer.setId(id);
        assertEquals(id, customer.getId());
    }

    @Test
    public void testDefaultConstructor() {
        Customer newCustomer = new Customer();
        assertNull(newCustomer.getId());
    }

}
