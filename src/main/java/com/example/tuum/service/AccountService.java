package com.example.tuum.service;

import com.example.tuum.utility.CurrencyValidator;
import com.example.tuum.domain.Account;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.repository.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountMapper accountMapper;
    private final BalanceService balanceService;

    @Autowired
    public AccountService(AccountMapper accountMapper, BalanceService balanceService) {
        this.accountMapper = accountMapper;
        this.balanceService = balanceService;
    }

    public Account createAccount(Long customerId, String country, List<String> currencies) {

        for (String currency : currencies) {
            CurrencyValidator.validateCurrency(currency);
        }

        Account account = new Account(customerId, country);
        accountMapper.saveAccount(account);

        Long accountId = account.getId();

        for (String currency : currencies) {
            balanceService.saveBalance(accountId, currency, 0.0);
        }

        return account;
    }

    public Account getAccountById(Long accountId) {
        Account account = accountMapper.getAccountById(accountId);

        if (account == null) {
            throw new AccountNotFoundException("Account not found.");
        }

        return account;
    }
}
