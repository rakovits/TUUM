package com.example.tuum.repository;

import com.example.tuum.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customers WHERE id = #{id}")
    Customer getCustomerById(Long id);

    @Insert("INSERT INTO customers (id) VALUES (#{id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveCustomer(Customer customer);
}


