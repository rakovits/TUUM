package com.example.tuum.presentation;

public class CreateTransactionCommand {
    private final Long accountId;
    private final Double transactionAmount;
    private final String currency;
    private final String directionOfTransaction;
    private final String transactionDescription;

    public CreateTransactionCommand(Long accountId, Double transactionAmount, String currency, String directionOfTransaction, String description) {
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
        this.currency = currency;
        this.directionOfTransaction = directionOfTransaction;
        this.transactionDescription = description;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDirectionOfTransaction() {
        return directionOfTransaction;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

}
