package com.example.tuum;

import com.example.tuum.domain.Account;
import com.example.tuum.repository.AccountMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountTests {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testGetAllAccounts() {
        List<Account> accounts = accountMapper.getAllAccounts();

        Assertions.assertNotNull(accounts);
    }

    @Test
    public void testGetAccountById() {
        Long accountId = 1L;

        Account account = accountMapper.getAccountById(accountId);

        Assertions.assertNotNull(account);
    }

    @Test
    public void testGetAccountByCustomerId() {
        Long customerId = 1L;

        List<Account> accounts = accountMapper.getAccountsByCustomerId(customerId);

        Assertions.assertNotNull(accounts);
    }

    @Test
    public void testGetAccountsByCustomerName() {
        String firstName = "Heli";
        String lastName = "Kopter";

        List<Account> accounts = accountMapper.getAccountsByCustomerName(firstName, lastName);

        Assertions.assertNotNull(accounts);
    }

    @Test
    public void testSaveAccount() {
        Long customerId = 1L;
        String country = "USA";

        Account account = new Account(customerId, country);

        accountMapper.saveAccount(account);

        Assertions.assertNotNull(account.getId());
    }
}
