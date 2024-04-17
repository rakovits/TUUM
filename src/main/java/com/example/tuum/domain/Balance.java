package com.example.tuum.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    private String currency;
    private Double availableAmount;


    public Balance() {
    }

    public Balance(Long accountId, String currency, Double availableAmount) {
        this.accountId = accountId;
        this.currency = currency;
        this.availableAmount = availableAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", currency='" + currency + '\'' +
                ", availableAmount=" + availableAmount +
                '}';
    }
}

