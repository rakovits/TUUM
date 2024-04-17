package com.example.tuum.repository;

import com.example.tuum.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Select("SELECT * FROM transactions")
    List<Transaction> getAllTransactions();

    @Select("SELECT * FROM transactions WHERE id = #{id}")
    Transaction getTransactionById(Long id);

    @Select("SELECT * FROM transactions WHERE balanceId = #{balanceId}")
    List<Transaction> getTransactionsByBalanceId(Long balanceId);

    @Insert("INSERT INTO transactions (balanceId, amount, directionOfTransaction, transactionDescription) VALUES (#{balanceId}, #{amount}, #{directionOfTransaction}, #{transactionDescription})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveTransaction(Transaction transaction);
}
