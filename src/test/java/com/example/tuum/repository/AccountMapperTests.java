package com.example.tuum.repository;

import com.example.tuum.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountMapperTests {
    @Mock
    private AccountMapper accountMapper;

    @Test
    public void testGetAccountById() {
        Account expectedAccount = new Account();
        expectedAccount.setId(1L);
        expectedAccount.setCustomerId(101L);
        expectedAccount.setCountry("USA");

        when(accountMapper.getAccountById(anyLong())).thenReturn(expectedAccount);

        Account retrievedAccount = accountMapper.getAccountById(1L);

        assertEquals(expectedAccount, retrievedAccount);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setCustomerId(201L);
        account.setCountry("Canada");

        accountMapper.saveAccount(account);

        verify(accountMapper).saveAccount(account);
    }
}
