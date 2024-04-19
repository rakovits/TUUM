package com.example.tuum.utility;

import com.example.tuum.domain.Account;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.service.AccountService;

public class AccountValidator {

    public static void validateAccount(Long accountId, AccountService accountService) {
        Account account = accountService.getAccountById(accountId);

        if (account == null) {
            throw new AccountNotFoundException("Invalid account id: " + accountId + ".");
        }
    }
}
