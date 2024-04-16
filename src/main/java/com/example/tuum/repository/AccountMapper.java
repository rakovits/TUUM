package com.example.tuum.repository;

import com.example.tuum.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM accounts")
    List<Account> getAllAccounts();

    @Select("SELECT * FROM accounts WHERE id = #{id}")
    Account getAccountById(Long id);

    @Select("SELECT * FROM accounts WHERE customerId = #{customerId}")
    List<Account> getAccountsByCustomerId(Long customerId);

    @Select("SELECT a.* FROM accounts a JOIN customers c ON a.customerId = c.id WHERE c.firstName = #{firstName} AND c.lastName = #{lastName}")
    List<Account> getAccountsByCustomerName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Insert("INSERT INTO accounts (customerId, country) VALUES (#{customerId}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveAccount(Account account);
}
