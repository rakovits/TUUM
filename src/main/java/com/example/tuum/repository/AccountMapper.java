package com.example.tuum.repository;

import com.example.tuum.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM accounts WHERE id = #{id}")
    Account getAccountById(Long id);

    @Insert("INSERT INTO accounts (customerId, country) VALUES (#{customerId}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveAccount(Account account);
}
