package com.example.tuum.presentation;

import java.util.List;

public class CreateAccountCommand {
    private Long customerId;
    private String country;
    private List<String> currencies;

    public CreateAccountCommand(Long customerId, String country, List<String> currencies) {
        this.customerId = customerId;
        this.country = country;
        this.currencies = currencies;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }
}
