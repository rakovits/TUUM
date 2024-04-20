package com.example.tuum.service;

import com.example.tuum.exceptions.InvalidCurrencyException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
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
    private final CustomerService customerService;
    private final BalanceService balanceService;

    @Autowired
    public AccountService(CustomerService customerService, AccountMapper accountMapper, BalanceService balanceService) {
        this.customerService = customerService;
        this.accountMapper = accountMapper;
        this.balanceService = balanceService;
    }

    public Account getAccountById(Long accountId) {
        Account account = accountMapper.getAccountById(accountId);

        if (account == null) {
            throw new AccountNotFoundException("Account not found.");
        }

        return account;
    }

    public Account createAccount(Long customerId, String country, List<String> currencies) {
        validateCurrencies(currencies);

        customerService.createCustomer(customerId);

        Account account = new Account(customerId, country);
        accountMapper.saveAccount(account);

        Long accountId = account.getId();

        for (String currency : currencies) {
            balanceService.createBalance(accountId, currency);
        }

        return account;
    }

    private void validateCurrencies(List<String> currencies) {
        for (String currency : currencies) {
            try {
                CurrencyValidator.validateCurrency(currency);
            } catch (InvalidCurrencyException e) {
                throw new InvalidResourceFieldException("Account not created due to invalid currency: " + currency + ". List of valid currencies: EUR, SEK, GBP, USD.");
            }
        }
    }
}
