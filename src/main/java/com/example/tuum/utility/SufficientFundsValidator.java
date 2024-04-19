package com.example.tuum.utility;

import com.example.tuum.exceptions.InsufficientFundsException;
import com.example.tuum.domain.Balance;
import com.example.tuum.service.BalanceService;

public class SufficientFundsValidator {
    public static void validateSufficientFunds(Long accountId, Double transactionAmount, String currency, String directionOfTransaction, BalanceService balanceService) {
        Balance balance = balanceService.getBalanceByAccountIdAndCurrency(accountId, currency);

        Double accountBalance = balance.getAvailableAmount();

        if (directionOfTransaction.equals("OUT") && accountBalance < transactionAmount) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
    }
}
