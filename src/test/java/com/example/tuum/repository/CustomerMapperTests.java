package com.example.tuum.repository;

import com.example.tuum.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerMapperTests {
    @Mock
    private CustomerMapper customerMapper;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = Arrays.asList(
                new Customer("Sue", "Permann"),
                new Customer("Anita", "Bath")
        );

        when(customerMapper.getAllCustomers()).thenReturn(customers);

        List<Customer> result = customerMapper.getAllCustomers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(customers, result);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer("Sue", "Permann");
        customer.setId(1L);

        when(customerMapper.getCustomerById(customer.getId())).thenReturn(customer);

        Customer result = customerMapper.getCustomerById(customer.getId());

        assertNotNull(result);
        assertEquals(customer, result);
        assertEquals(customer.getId(), result.getId());
    }

    @Test
    public void testGetCustomerByName() {
        Customer customer = new Customer("Sue", "Permann");

        when(customerMapper.getCustomerByName(customer.getFirstName(), customer.getLastName())).thenReturn(customer);

        Customer result = customerMapper.getCustomerByName(customer.getFirstName(), customer.getLastName());

        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("Sue", "Permann");

        doNothing().when(customerMapper).saveCustomer(customer);
        customerMapper.saveCustomer(customer);

        verify(customerMapper, times(1)).saveCustomer(customer);
        verifyNoMoreInteractions(customerMapper);
    }
}