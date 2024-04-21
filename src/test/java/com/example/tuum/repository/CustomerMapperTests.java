package com.example.tuum.repository;

import com.example.tuum.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerMapperTests {
    @Mock
    private CustomerMapper customerMapper;

    @Test
    public void testGetCustomerById() {
        Customer expectedCustomer = new Customer();
        expectedCustomer.setId(1L);

        when(customerMapper.getCustomerById(anyLong())).thenReturn(expectedCustomer);

        Customer retrievedCustomer = customerMapper.getCustomerById(1L);

        assertEquals(expectedCustomer, retrievedCustomer);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setId(2L);

        customerMapper.saveCustomer(customer);

        verify(customerMapper).saveCustomer(customer);
    }
}
