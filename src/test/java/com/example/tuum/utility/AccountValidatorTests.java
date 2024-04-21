package com.example.tuum.utility;

import com.example.tuum.domain.Account;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountValidatorTests {
    @Mock
    private AccountService accountService;

    @Test
    public void testValidateAccount_AccountExists() {
        when(accountService.getAccountById(anyLong())).thenReturn(new Account());

        AccountValidator.validateAccount(1L, accountService);

        // No exception should be thrown
    }

    @Test
    public void testValidateAccount_AccountDoesNotExist() {
        when(accountService.getAccountById(anyLong())).thenReturn(null);

        assertThrows(AccountNotFoundException.class, () -> AccountValidator.validateAccount(1L, accountService));
    }
}
