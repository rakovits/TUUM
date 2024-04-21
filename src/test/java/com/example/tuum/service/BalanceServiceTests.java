package com.example.tuum.service;

import com.example.tuum.domain.Balance;
import com.example.tuum.exceptions.BalanceNotFoundException;
import com.example.tuum.repository.BalanceMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BalanceServiceTests {
    @Mock
    private BalanceMapper balanceMapper;

    @InjectMocks
    private BalanceService balanceService;

    @Test
    void testCreateBalance() {
        doAnswer(invocation -> {
            Balance savedBalance = invocation.getArgument(0);
            savedBalance.setId(1L);
            return savedBalance;
        }).when(balanceMapper).saveBalance(any(Balance.class));

        Balance createdBalance = balanceService.createBalance(123L, "USD");

        assertNotNull(createdBalance);
        assertEquals(123L, createdBalance.getAccountId());
        assertEquals("USD", createdBalance.getCurrency());
        assertEquals(0.0, createdBalance.getAvailableAmount());
        assertNotNull(createdBalance.getId());
        verify(balanceMapper, times(1)).saveBalance(any(Balance.class));
    }

    @Test
    void testGetBalanceByAccountIdAndCurrency_ExistingBalance() {
        when(balanceMapper.getBalanceByAccountIdAndCurrency(anyLong(), any(String.class)))
                .thenReturn(new Balance(1L, "USD", 100.0));

        Balance balance = balanceService.getBalanceByAccountIdAndCurrency(1L, "USD");

        assertNotNull(balance);
        assertEquals(1L, balance.getAccountId());
        assertEquals("USD", balance.getCurrency());
        assertEquals(100.0, balance.getAvailableAmount());
    }

    @Test
    void testGetBalanceByAccountIdAndCurrency_NonExistingBalance() {
        when(balanceMapper.getBalanceByAccountIdAndCurrency(anyLong(), any(String.class)))
                .thenReturn(null);

        assertThrows(BalanceNotFoundException.class, () -> balanceService.getBalanceByAccountIdAndCurrency(1L, "USD"));
    }

    @Test
    void testGetBalancesByAccountId() {
        List<Balance> balances = new ArrayList<>();
        balances.add(new Balance(1L, "USD", 100.0));
        balances.add(new Balance(1L, "EUR", 200.0));
        when(balanceMapper.getBalancesByAccountId(anyLong())).thenReturn(balances);

        List<Balance> result = balanceService.getBalancesByAccountId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getAccountId());
        assertEquals(1L, result.get(1).getAccountId());
        assertEquals("USD", result.get(0).getCurrency());
        assertEquals("EUR", result.get(1).getCurrency());
        assertEquals(100.0, result.get(0).getAvailableAmount());
        assertEquals(200.0, result.get(1).getAvailableAmount());
        verify(balanceMapper, times(1)).getBalancesByAccountId(1L);
    }

    @Test
    void testGetBalanceById_ExistingBalance() {
        when(balanceMapper.getBalanceById(anyLong())).thenReturn(new Balance(1L, "USD", 100.0));

        Balance balance = balanceService.getBalanceById(1L);
        balance.setId(1L);

        assertNotNull(balance);
        assertEquals(1L, balance.getId());
        assertEquals("USD", balance.getCurrency());
        assertEquals(100.0, balance.getAvailableAmount());
        verify(balanceMapper, times(1)).getBalanceById(1L);
    }

    @Test
    void testGetBalanceById_NonExistingBalance() {
        when(balanceMapper.getBalanceById(anyLong())).thenReturn(null);

        System.out.println("Before calling balanceService.getBalanceById");

        assertThrows(BalanceNotFoundException.class, () -> balanceService.getBalanceById(1L));

        System.out.println("After calling balanceService.getBalanceById");

        verify(balanceMapper, times(1)).getBalanceById(1L);
    }

    @Test
    void testUpdateBalance() {
        Balance balance = new Balance(1L, "USD", 100.0);
        balanceService.updateBalance(balance);

        verify(balanceMapper, times(1)).updateBalance(balance);
    }
}
