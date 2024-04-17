package com.example.tuum.service;

import com.example.tuum.domain.Balance;
import com.example.tuum.repository.BalanceMapper;
import org.springframework.stereotype.Service;

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
}
