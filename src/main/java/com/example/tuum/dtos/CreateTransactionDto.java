package com.example.tuum.dtos;

public class CreateTransactionDto {
    private Long transactionId;
    private Long accountId;
    private Double transactionAmount;
    private String currency;
    private String directionOfTransaction;
    private String transactionDescription;
    private Double availableAmountAfterTransaction;

    public CreateTransactionDto(Long transactionId, Long accountId, Double transactionAmount, String currency, String directionOfTransaction, String description, Double availableAmountAfterTransaction) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
        this.currency = currency;
        this.directionOfTransaction = directionOfTransaction;
        this.transactionDescription = description;
        this.availableAmountAfterTransaction = availableAmountAfterTransaction;
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

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAvailableAmountAfterTransaction() {
        return availableAmountAfterTransaction;
    }

    public void setAvailableAmountAfterTransaction(Double availableAmountAfterTransaction) {
        this.availableAmountAfterTransaction = availableAmountAfterTransaction;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
