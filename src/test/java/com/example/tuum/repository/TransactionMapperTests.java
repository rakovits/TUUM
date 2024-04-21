package com.example.tuum.repository;

import com.example.tuum.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionMapperTests {
    @Mock
    private TransactionMapper transactionMapper;

    @Test
    public void testGetTransactionsByBalanceId() {
        List<Transaction> expectedTransactions = Collections.singletonList(new Transaction());

        when(transactionMapper.getTransactionsByBalanceId(anyLong())).thenReturn(expectedTransactions);

        List<Transaction> retrievedTransactions = transactionMapper.getTransactionsByBalanceId(1L);

        assertEquals(expectedTransactions, retrievedTransactions);
    }

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setBalanceId(1L);
        transaction.setTransactionAmount(100.0);
        transaction.setDirectionOfTransaction("IN");
        transaction.setTransactionDescription("Deposit");

        transactionMapper.saveTransaction(transaction);

        verify(transactionMapper).saveTransaction(transaction);
    }
}
