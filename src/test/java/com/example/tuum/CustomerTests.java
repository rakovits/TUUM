package com.example.tuum;

import com.example.tuum.domain.Customer;
import com.example.tuum.repository.CustomerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerTests {
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = customerMapper.getAllCustomers();
        Assertions.assertNotNull(customers);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = customerMapper.getCustomerById(1L);
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testGetCustomerByName() {
        Customer customer = customerMapper.getCustomerByName("Heli", "Kopter");
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("Kiisu", "Miisu");
        customerMapper.saveCustomer(customer);
        Assertions.assertNotNull(customer.getId());
    }
}

