package com.example.tuum.repository;

import com.example.tuum.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Select("SELECT * FROM transactions WHERE balanceId = #{balanceId}")
    List<Transaction> getTransactionsByBalanceId(Long balanceId);

    @Insert("INSERT INTO transactions (balanceId, transactionAmount, directionOfTransaction, transactionDescription) VALUES (#{balanceId}, #{transactionAmount}, #{directionOfTransaction}, #{transactionDescription})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveTransaction(Transaction transaction);
}
