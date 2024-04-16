package com.example.tuum.repository;

import com.example.tuum.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customers")
    List<Customer> getAllCustomers();

    @Select("SELECT * FROM customers WHERE id = #{id}")
    Customer getCustomerById(Long id);

    @Select("SELECT * FROM customers WHERE firstName = #{firstName} AND lastName = #{lastName}")
    Customer getCustomerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Insert("INSERT INTO customers (firstName, lastName) VALUES (#{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveCustomer(Customer customer);

    // Should I add delete and change options as well?

}


