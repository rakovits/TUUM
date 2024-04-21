package com.example.tuum.service;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.exceptions.InvalidCurrencyException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.exceptions.InvalidTransactionDirectionException;
import com.example.tuum.exceptions.InvalidTransactionAmountException;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidTransactionDescriptionException;
import com.example.tuum.exceptions.InsufficientFundsException;
import com.example.tuum.repository.TransactionMapper;
import com.example.tuum.utility.AccountValidator;
import com.example.tuum.utility.CurrencyValidator;
import com.example.tuum.utility.TransactionDirectionValidator;
import com.example.tuum.utility.TransactionAmountValidator;
import com.example.tuum.utility.TransactionDescriptionValidator;
import com.example.tuum.utility.SufficientFundsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        validateAccount(accountId);

        List<Transaction> accountTransactions = new ArrayList<>();

        List<Balance> allAccountBalances = balanceService.getBalancesByAccountId(accountId);

        for (Balance balance : allAccountBalances) {
            Long balanceId = balance.getId();

            List<Transaction> balanceTransactions = transactionMapper.getTransactionsByBalanceId(balanceId);
            accountTransactions.addAll(balanceTransactions);
        }

        return accountTransactions;
    }

    public Transaction createTransaction(Long accountId, Double transactionAmount, String currency, String directionOfTransaction, String transactionDescription) {
        validateCurrency(currency);
        validateTransactionDirection(directionOfTransaction);
        validateTransactionAmount(transactionAmount);
        validateAccount(accountId);
        validateTransactionDescription(transactionDescription);
        validateSufficientFunds(accountId, transactionAmount, currency, directionOfTransaction);

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

    private void validateCurrency(String currency) {
        try {
            CurrencyValidator.validateCurrency(currency);
        } catch (InvalidCurrencyException e) {
            throw new InvalidResourceFieldException("Invalid currency: " + currency + ". List of valid currencies: EUR, SEK, GBP, USD.");
        }
    }

    private void validateTransactionDirection(String directionOfTransaction) {
        try {
            TransactionDirectionValidator.validateTransactionDirection(directionOfTransaction);
        } catch (InvalidTransactionDirectionException e) {
            throw new InvalidResourceFieldException("Invalid transaction direction: " + directionOfTransaction + ". List of valid transaction directions: IN, OUT.");
        }
    }

    private void validateTransactionAmount(Double transactionAmount) {
        try {
            TransactionAmountValidator.validateTransactionAmount(transactionAmount);
        } catch (InvalidTransactionAmountException e) {
            throw new InvalidResourceFieldException("Invalid transaction amount: " + transactionAmount + ". The transaction amount must be greater than zero and can have up to two decimal places.");
        }
    }

    private void validateAccount(Long accountId) {
        try {
            AccountValidator.validateAccount(accountId, accountService);
        } catch (AccountNotFoundException e) {
            throw new InvalidResourceFieldException("Invalid account id: " + accountId + ".");
        }
    }

    private void validateTransactionDescription(String transactionDescription) {
        try {
            TransactionDescriptionValidator.validateTransactionDescription(transactionDescription);
        } catch (InvalidTransactionDescriptionException e) {
            throw new InvalidResourceFieldException("Missing description.");
        }
    }

    private void validateSufficientFunds(Long accountId, Double transactionAmount, String currency, String directionOfTransaction) {
        try {
            SufficientFundsValidator.validateSufficientFunds(accountId, transactionAmount, currency, directionOfTransaction, balanceService);
        } catch (InsufficientFundsException e) {
            throw new InvalidResourceFieldException("Insufficient funds.");
        }
    }
}
