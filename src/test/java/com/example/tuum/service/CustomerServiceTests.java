package com.example.tuum.service;

import com.example.tuum.domain.Customer;
import com.example.tuum.repository.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerServiceTests {
    @Mock
    private CustomerMapper customerMapper;

    @Test
    public void testCreateCustomer_NewCustomer() {

        CustomerService customerService = new CustomerService(customerMapper);
        Long customerId = 123L;
        when(customerMapper.getCustomerById(customerId)).thenReturn(null);

        doAnswer(invocation -> {
            Customer savedCustomer = invocation.getArgument(0);
            savedCustomer.setId(customerId);
            return null;
        }).when(customerMapper).saveCustomer(any(Customer.class));


        Customer createdCustomer = customerService.createCustomer(customerId);


        assertNotNull(createdCustomer);
        assertEquals(customerId, createdCustomer.getId());
        verify(customerMapper, times(1)).saveCustomer(any(Customer.class));
    }

    @Test
    public void testCreateCustomer_ExistingCustomer() {
        CustomerService customerService = new CustomerService(customerMapper);
        Long customerId = 123L;
        Customer existingCustomer = new Customer();
        existingCustomer.setId(customerId);

        when(customerMapper.getCustomerById(customerId)).thenReturn(existingCustomer);

        Customer createdCustomer = customerService.createCustomer(customerId);
        createdCustomer.setId(123L);

        assertNotNull(createdCustomer);
        assertEquals(customerId, createdCustomer.getId());
        verify(customerMapper, never()).saveCustomer(any(Customer.class));
    }
}
