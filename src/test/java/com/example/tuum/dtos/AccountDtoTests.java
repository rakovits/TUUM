package com.example.tuum.dtos;

import com.example.tuum.domain.BalanceFields;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountDtoTests {
    @Test
    public void testAccountId() {
        Long accountId = 123L;
        Long customerId = 456L;
        List<BalanceFields> balances = new ArrayList<>();
        AccountDto accountDto = new AccountDto(accountId, customerId, balances);

        Long newAccountId = 789L;
        accountDto.setAccountId(newAccountId);
        assertEquals(newAccountId, accountDto.getAccountId());
    }

    @Test
    public void testCustomerId() {
        Long accountId = 123L;
        Long customerId = 456L;
        List<BalanceFields> balances = new ArrayList<>();
        AccountDto accountDto = new AccountDto(accountId, customerId, balances);

        Long newCustomerId = 101L;
        accountDto.setCustomerId(newCustomerId);
        assertEquals(newCustomerId, accountDto.getCustomerId());
    }

    @Test
    public void testBalances() {
        Long accountId = 123L;
        Long customerId = 456L;
        List<BalanceFields> balances = new ArrayList<>();
        AccountDto accountDto = new AccountDto(accountId, customerId, balances);

        List<BalanceFields> newBalances = new ArrayList<>();
        newBalances.add(new BalanceFields(100.0, "USD"));
        accountDto.setBalances(newBalances);
        assertEquals(newBalances, accountDto.getBalances());
    }
}
