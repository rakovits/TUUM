package com.example.tuum.repository;

import com.example.tuum.domain.Account;
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
public class AccountMapperTests {
    @Mock
    private AccountMapper accountMapper;

    @Test
    public void testGetAllAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account(1L, "Estonia"),
                new Account(1L, "Norway"),
                new Account(2L, "Estonia")
        );

        when(accountMapper.getAllAccounts()).thenReturn(accounts);

        List<Account> result = accountMapper.getAllAccounts();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(accounts, result);
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account(1L, "Estonia");
        account.setId(1L);

        when(accountMapper.getAccountById(account.getId())).thenReturn(account);

        Account result = accountMapper.getAccountById(account.getId());

        assertNotNull(result);
        assertEquals(account, result);
        assertEquals(account.getId(), result.getId());
    }

    @Test
    public void testGetAccountsByCustomerId() {
        List<Account> accounts = Arrays.asList(
                new Account(1L, "Estonia"),
                new Account(1L, "Norway"),
                new Account(2L, "Estonia")
        );

        when(accountMapper.getAccountsByCustomerId(1L)).thenReturn(Arrays.asList(accounts.get(0), accounts.get(1)));

        List<Account> result = accountMapper.getAccountsByCustomerId(1L);

        assertNotNull(result);
        assertTrue(result.contains(accounts.get(0)));
        assertTrue(result.contains(accounts.get(1)));
        assertFalse(result.contains(accounts.get(2)));
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account(1L, "Estonia");

        doNothing().when(accountMapper).saveAccount(account);
        accountMapper.saveAccount(account);

        verify(accountMapper, times(1)).saveAccount(account);
        verifyNoMoreInteractions(accountMapper);
    }
}
