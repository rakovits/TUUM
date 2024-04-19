package com.example.tuum.service;

import com.example.tuum.exceptions.BalanceNotFoundException;
import com.example.tuum.domain.Balance;
import com.example.tuum.repository.BalanceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    private final BalanceMapper balanceMapper;

    public BalanceService(BalanceMapper balanceMapper) {
        this.balanceMapper = balanceMapper;
    }

    public Balance createBalance(Long accountId, String currency) {
        Balance balance = new Balance(accountId, currency, 0.0);
        balanceMapper.saveBalance(balance);

        return balance;
    }

    public Balance getBalanceByAccountIdAndCurrency(Long accountId, String currency) {
        Balance balance = balanceMapper.getBalanceByAccountIdAndCurrency(accountId, currency);

        if (balance == null) {
            throw new BalanceNotFoundException("Balance for currency " + currency + " not found.");
        }

        return balance;
    }

    public List<Balance> getBalancesByAccountId(Long accountId) {
        List<Balance> balances = balanceMapper.getBalancesByAccountId(accountId);

        return balances;
    }

    public void updateBalance(Balance balance) {
        balanceMapper.updateBalance(balance);
    }
}
