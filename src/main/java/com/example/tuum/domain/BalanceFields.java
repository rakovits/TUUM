package com.example.tuum.domain;

import java.io.Serializable;

public class BalanceFields implements Serializable {

    private final Double availableAmount;
    private final String currency;

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public BalanceFields(Double availableAmount, String currency) {
        this.availableAmount = availableAmount;
        this.currency = currency;
    }
}
