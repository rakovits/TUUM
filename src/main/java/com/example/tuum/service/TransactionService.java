package com.example.tuum.service;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.exceptions.*;
import com.example.tuum.repository.TransactionMapper;
import com.example.tuum.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionMapper transactionMapper;
    private final AccountService accountService;
    private final BalanceService balanceService;

    @Autowired
    public TransactionService(TransactionMapper transactionMapper, AccountService accountService, BalanceService balanceService) {
        this.transactionMapper = transactionMapper;
        this.accountService = accountService;
        this.balanceService = balanceService;
    }

    public Transaction createTransaction(Long accountId, Double transactionAmount, String currency, String directionOfTransaction, String transactionDescription) {
        // Validating currency
        try {
            CurrencyValidator.validateCurrency(currency);
        } catch (InvalidCurrencyException e) {
            throw new InvalidResourceFieldException("Transaction not created due to invalid currency: " + currency + ". List of valid currencies: EUR, SEK, GBP, USD.");
        }

        // Validating direction
        try {
            TransactionDirectionValidator.validateTransactionDirection(directionOfTransaction);
        } catch (InvalidTransactionDirectionException e) {
            throw new InvalidResourceFieldException("Transaction not created due to invalid transaction direction: " + directionOfTransaction + ". List of valid transaction directions: IN, OUT.");
        }

        // Validating amount
        try {
            TransactionAmountValidator.validateTransactionAmount(transactionAmount);
        } catch (InvalidTransactionAmountException e) {
            throw new InvalidResourceFieldException("Transaction not created due to invalid transaction amount: " + transactionAmount + ". The transaction amount must be greater than zero and can have up to two decimal places.");
        }

        // Validating account
        try {
            AccountValidator.validateAccount(accountId, accountService);
        } catch (AccountNotFoundException e) {
            throw new InvalidResourceFieldException("Transaction not created due to invalid account id: " + accountId + ".");
        }

        // Validating description
        try {
            TransactionDescriptionValidator.validateTransactionDescription(transactionDescription);
        } catch (InvalidTransactionDescriptionException e) {
            throw new InvalidResourceFieldException("Transaction not created due to missing description.");
        }

        // Insufficient funds
        try {
            SufficientFundsValidator.validateSufficientFunds(accountId, transactionAmount, currency, directionOfTransaction, balanceService);
        } catch (InsufficientFundsException e) {
            throw new InvalidResourceFieldException("Transaction not created due to insufficient funds.");
        }


        Balance balance = balanceService.getBalanceByAccountIdAndCurrency(accountId, currency);
        Long balanceId = balance.getId();

        Transaction transaction = new Transaction(balanceId, transactionAmount, directionOfTransaction, transactionDescription);
        transactionMapper.saveTransaction(transaction);

        double newAvailableAmount;

        if (directionOfTransaction.equals("IN")) {
            newAvailableAmount = balance.getAvailableAmount() + transactionAmount;
        } else {
            newAvailableAmount = balance.getAvailableAmount() - transactionAmount;
        }

        balance.setAvailableAmount(newAvailableAmount);
        balanceService.updateBalance(balance);

        return transaction;
    }
}
