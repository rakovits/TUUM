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
    private Double amount;
    private String directionOfTransaction;
    private String transactionDescription;

    public Transaction() {

    }

    public Transaction(Long balanceId, Double amount, String directionOfTransaction, String transactionDescription) {
        this.balanceId = balanceId;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", balanceId=" + balanceId +
                ", amount=" + amount +
                ", directionOfTransaction='" + directionOfTransaction + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                '}';
    }
}