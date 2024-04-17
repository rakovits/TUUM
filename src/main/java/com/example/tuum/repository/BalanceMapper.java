package com.example.tuum.repository;

import com.example.tuum.domain.Balance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BalanceMapper {
    @Select("SELECT * FROM balances")
    List<Balance> getAllBalances();

    @Select("SELECT * FROM balances WHERE id = #{id}")
    Balance getBalanceById(Long id);

    @Select("SELECT * FROM balances WHERE accountId = #{accountId}")
    List<Balance> getBalancesByAccountId(Long accountId);

    @Select("SELECT * FROM balances WHERE accountId = #{accountId} AND currency = #{currency}")
    Balance getBalanceByAccountIdAndCurrency(@Param("accountId") Long accountId, @Param("currency") String currency);

    @Insert("INSERT INTO balances (accountId, currency, availableAmount) VALUES (#{accountId}, #{currency}, #{availableAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveBalance(Balance balance);

    @Update("UPDATE balances SET accountId = #{accountId}, currency = #{currency}, availableAmount = #{availableAmount} WHERE id = #{id}")
    void updateBalance(Balance balance);
}

