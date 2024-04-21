package com.example.tuum.repository;

import com.example.tuum.domain.Balance;
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
public class BalanceMapperTests {
    @Mock
    private BalanceMapper balanceMapper;

    @Test
    public void testGetBalanceById() {
        Balance expectedBalance = new Balance();
        expectedBalance.setId(1L);
        expectedBalance.setAccountId(101L);
        expectedBalance.setCurrency("USD");
        expectedBalance.setAvailableAmount(100.0);

        when(balanceMapper.getBalanceById(anyLong())).thenReturn(expectedBalance);

        Balance retrievedBalance = balanceMapper.getBalanceById(1L);

        assertEquals(expectedBalance, retrievedBalance);
    }

    @Test
    public void testGetBalancesByAccountId() {
        List<Balance> expectedBalances = Collections.singletonList(new Balance());

        when(balanceMapper.getBalancesByAccountId(anyLong())).thenReturn(expectedBalances);

        List<Balance> retrievedBalances = balanceMapper.getBalancesByAccountId(101L);

        assertEquals(expectedBalances, retrievedBalances);
    }

    @Test
    public void testGetBalanceByAccountIdAndCurrency() {
        Balance expectedBalance = new Balance();
        expectedBalance.setId(1L);
        expectedBalance.setAccountId(101L);
        expectedBalance.setCurrency("USD");
        expectedBalance.setAvailableAmount(100.0);

        when(balanceMapper.getBalanceByAccountIdAndCurrency(101L, "USD")).thenReturn(expectedBalance);

        Balance retrievedBalance = balanceMapper.getBalanceByAccountIdAndCurrency(101L, "USD");

        assertEquals(expectedBalance, retrievedBalance);
    }

    @Test
    public void testSaveBalance() {
        Balance balance = new Balance();
        balance.setAccountId(101L);
        balance.setCurrency("USD");
        balance.setAvailableAmount(100.0);

        balanceMapper.saveBalance(balance);

        verify(balanceMapper).saveBalance(balance);
    }

    @Test
    public void testUpdateBalance() {
        Balance balance = new Balance();
        balance.setId(1L);
        balance.setAccountId(101L);
        balance.setCurrency("USD");
        balance.setAvailableAmount(100.0);

        balanceMapper.updateBalance(balance);

        verify(balanceMapper).updateBalance(balance);
    }
}
