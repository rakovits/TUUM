package com.example.tuum.service;

import com.example.tuum.domain.Account;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.repository.AccountMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceTests {
    @Mock
    private AccountMapper accountMapper;

    @Mock
    private CustomerService customerService;

    @Mock
    private BalanceService balanceService;

    @InjectMocks
    private AccountService accountService;

    @Test
    void testGetAccountById_AccountFound() {
        Long accountId = 123L;
        Account expectedAccount = new Account(accountId, "UK");
        when(accountMapper.getAccountById(accountId)).thenReturn(expectedAccount);

        Account actualAccount = accountService.getAccountById(accountId);

        assertNotNull(actualAccount);
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    void testGetAccountById_AccountNotFound() {
        Long accountId = 123L;
        when(accountMapper.getAccountById(accountId)).thenReturn(null);

        assertThrows(AccountNotFoundException.class, () -> accountService.getAccountById(accountId));
    }

    @Test
    void testCreateAccount_ValidInput() {
        Long customerId = 123L;
        String country = "US";
        List<String> currencies = List.of("USD");

        doAnswer(invocation -> {
            Account savedAccount = invocation.getArgument(0);
            savedAccount.setId(1L);
            return null;
        }).when(accountMapper).saveAccount(any(Account.class));

        Account createdAccount = accountService.createAccount(customerId, country, currencies);

        assertNotNull(createdAccount);
        assertEquals(customerId, createdAccount.getCustomerId());
        assertEquals(country, createdAccount.getCountry());
        verify(customerService, times(1)).createCustomer(customerId);
        verify(accountMapper, times(1)).saveAccount(any(Account.class));
        verify(balanceService, times(1)).createBalance(anyLong(), anyString());
    }

    @Test
    void testCreateAccount_InvalidCurrency() {
        Long customerId = 123L;
        String country = "US";
        List<String> currencies = Collections.singletonList("INVALID");

        assertThrows(InvalidResourceFieldException.class, () -> accountService.createAccount(customerId, country, currencies));
        verify(customerService, never()).createCustomer(anyLong());
        verify(accountMapper, never()).saveAccount(any(Account.class));
        verify(balanceService, never()).createBalance(anyLong(), anyString());
    }
}

