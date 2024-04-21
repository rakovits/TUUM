package com.example.tuum.converters;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.CreateTransactionDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionToCreateTransactionDtoConverterTests {
    @Test
    public void testConvertTransactionToCreateTransactionDto() {
        TransactionToCreateTransactionDtoConverter converter = new TransactionToCreateTransactionDtoConverter();

        Transaction transaction = new Transaction();
        transaction.setId(123L);
        transaction.setTransactionAmount(100.0);
        transaction.setDirectionOfTransaction("IN");
        transaction.setTransactionDescription("Payment");

        Balance balance = new Balance();
        balance.setAccountId(456L);
        balance.setCurrency("USD");
        balance.setAvailableAmount(500.0);

        CreateTransactionDto createTransactionDto = converter.convertTransactionToCreateTransactionDTO(transaction, balance);

        assertEquals(transaction.getId(), createTransactionDto.getTransactionId());
        assertEquals(balance.getAccountId(), createTransactionDto.getAccountId());
        assertEquals(transaction.getTransactionAmount(), createTransactionDto.getTransactionAmount());
        assertEquals(balance.getCurrency(), createTransactionDto.getCurrency());
        assertEquals(transaction.getDirectionOfTransaction(), createTransactionDto.getDirectionOfTransaction());
        assertEquals(transaction.getTransactionDescription(), createTransactionDto.getTransactionDescription());
        assertEquals(balance.getAvailableAmount(), createTransactionDto.getAvailableAmountAfterTransaction());
    }
}
