package com.example.tuum.repository;

import com.example.tuum.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.times;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionMapperTests {
    @Mock
    private TransactionMapper transactionMapper;

    @Test
    public void testGetAllTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, 10.0, "OUT", "Description"),
                new Transaction(1L, 15.0, "IN", "Description"),
                new Transaction(2L, 100.50, "OUT", "Description")
        );

        when(transactionMapper.getAllTransactions()).thenReturn(transactions);

        List<Transaction> result = transactionMapper.getAllTransactions();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(transactions, result);
    }

    @Test
    public void testGetTransactionById() {
        Transaction transaction = new Transaction(1L, 10.0, "OUT", "Description");
        transaction.setId(1L);

        when(transactionMapper.getTransactionById(transaction.getId())).thenReturn(transaction);

        Transaction result = transactionMapper.getTransactionById(transaction.getId());

        assertNotNull(result);
        assertEquals(transaction, result);
        assertEquals(transaction.getId(), result.getId());
    }

    @Test
    public void testGetTransactionsByBalanceId() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, 10.0, "OUT", "Description"),
                new Transaction(1L, 15.0, "IN", "Description"),
                new Transaction(2L, 100.50, "OUT", "Description")
        );

        when(transactionMapper.getTransactionsByBalanceId(1L)).thenReturn(Arrays.asList(transactions.get(0), transactions.get(1)));

        List<Transaction> result = transactionMapper.getTransactionsByBalanceId(1L);

        assertNotNull(result);
        assertTrue(result.contains(transactions.get(0)));
        assertTrue(result.contains(transactions.get(1)));
        assertFalse(result.contains(transactions.get(2)));
    }

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction(1L, 10.0, "OUT", "Description");

        doNothing().when(transactionMapper).saveTransaction(transaction);
        transactionMapper.saveTransaction(transaction);

        verify(transactionMapper, times(1)).saveTransaction(transaction);
        verifyNoMoreInteractions(transactionMapper);
    }
}
