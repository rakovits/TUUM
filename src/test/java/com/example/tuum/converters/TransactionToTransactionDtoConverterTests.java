package com.example.tuum.converters;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.TransactionDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionToTransactionDtoConverterTests {
    @Test
    public void testConvertTransactionToTransactionDto() {
        TransactionToTransactionDtoConverter converter = new TransactionToTransactionDtoConverter();

        Transaction transaction = new Transaction();
        transaction.setId(123L);
        transaction.setTransactionAmount(100.0);
        transaction.setDirectionOfTransaction("IN");
        transaction.setTransactionDescription("Payment");

        Balance balance = new Balance();
        balance.setAccountId(456L);
        balance.setCurrency("USD");

        TransactionDto transactionDto = converter.convertTransactionToTransactionDTO(transaction, balance);

        assertEquals(transaction.getId(), transactionDto.getTransactionId());
        assertEquals(balance.getAccountId(), transactionDto.getAccountId());
        assertEquals(transaction.getTransactionAmount(), transactionDto.getTransactionAmount());
        assertEquals(balance.getCurrency(), transactionDto.getCurrency());
        assertEquals(transaction.getDirectionOfTransaction(), transactionDto.getDirectionOfTransaction());
        assertEquals(transaction.getTransactionDescription(), transactionDto.getTransactionDescription());
    }
}
