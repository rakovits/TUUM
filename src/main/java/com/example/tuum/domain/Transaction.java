package com.example.tuum.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long balanceId;
    private Double transactionAmount;
    private String directionOfTransaction;
    private String transactionDescription;

    public Transaction() {

    }

    public Transaction(Long balanceId, Double transactionAmount, String directionOfTransaction, String transactionDescription) {
        this.balanceId = balanceId;
        this.transactionAmount = transactionAmount;
        this.directionOfTransaction = directionOfTransaction;
        this.transactionDescription = transactionDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
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
