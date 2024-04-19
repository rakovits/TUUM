package com.example.tuum.dtos;

public class TransactionDTO {
    private Long accountId;
    private Double transactionAmount;
    private String currency;
    private String directionOfTransaction;
    private String transactionDescription;

    public TransactionDTO(Long accountId, Double transactionAmount, String currency, String directionOfTransaction, String description) {
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
        this.currency = currency;
        this.directionOfTransaction = directionOfTransaction;
        this.transactionDescription = description;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDirectionOfTransaction() {
        return directionOfTransaction;
    }

    public void setDirectionOfTransaction(String directionOfTransaction) {
        this.directionOfTransaction = directionOfTransaction;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
