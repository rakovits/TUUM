package com.example.tuum.repository;

import com.example.tuum.domain.Balance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BalanceMapperTests {
    @Mock
    private BalanceMapper balanceMapper;

    @Test
    public void testGetAllBalances() {
        List<Balance> balances = Arrays.asList(
                new Balance(1L, "EUR", 100.0),
                new Balance(1L, "USD", 200.0),
                new Balance(2L, "SEK", 123.45)
        );

        when(balanceMapper.getAllBalances()).thenReturn(balances);

        List<Balance> result = balanceMapper.getAllBalances();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(balances, result);
    }

    @Test
    public void testGetBalanceById() {
        Balance balance = new Balance(1L, "EUR", 100.0);
        balance.setId(1L);

        when(balanceMapper.getBalanceById(balance.getId())).thenReturn(balance);

        Balance result = balanceMapper.getBalanceById(balance.getId());

        assertNotNull(result);
        assertEquals(balance, result);
        assertEquals(balance.getId(), result.getId());
    }

    @Test
    public void testGetBalancesByAccountId() {
        List<Balance> balances = Arrays.asList(
                new Balance(1L, "EUR", 100.0),
                new Balance(1L, "USD", 200.0),
                new Balance(2L, "SEK", 123.45)
        );

        when(balanceMapper.getBalancesByAccountId(1L)).thenReturn(Arrays.asList(balances.get(0), balances.get(1)));

        List<Balance> result = balanceMapper.getBalancesByAccountId(1L);

        assertNotNull(result);
        assertTrue(result.contains(balances.get(0)));
        assertTrue(result.contains(balances.get(1)));
        assertFalse(result.contains(balances.get(2)));
    }

    @Test
    public void testGetBalanceByAccountIdAndCurrency() {
        List<Balance> balances = Arrays.asList(
                new Balance(1L, "EUR", 100.0),
                new Balance(1L, "USD", 200.0),
                new Balance(2L, "SEK", 123.45)
        );

        when(balanceMapper.getBalanceByAccountIdAndCurrency(1L, "EUR")).thenReturn(balances.get(0));

        Balance result = balanceMapper.getBalanceByAccountIdAndCurrency(balances.get(0).getAccountId(), balances.get(0).getCurrency());

        assertNotNull(result);
        assertEquals(balances.get(0), result);
    }

    @Test
    public void testSaveBalance() {
        Balance balance = new Balance(1L, "EUR", 100.0);

        doNothing().when(balanceMapper).saveBalance(balance);
        balanceMapper.saveBalance(balance);

        verify(balanceMapper, times(1)).saveBalance(balance);
        verifyNoMoreInteractions(balanceMapper);
    }

    @Test
    public void testUpdateBalance() {
        Balance balance = new Balance(1L, "EUR", 100.0);

        doNothing().when(balanceMapper).updateBalance(balance);
        balanceMapper.updateBalance(balance);

        verify(balanceMapper, times(1)).updateBalance(balance);
        verifyNoMoreInteractions(balanceMapper);
    }
}
