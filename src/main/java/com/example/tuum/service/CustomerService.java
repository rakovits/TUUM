package com.example.tuum.service;

import com.example.tuum.domain.Customer;
import com.example.tuum.repository.CustomerMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public Customer createCustomer(Long customerId) {
        Customer customer = new Customer();

        if (customerMapper.getCustomerById(customerId) == null) {
            customer.setId(customerId);
            customerMapper.saveCustomer(customer);
        }

        return customer;
    }
}
