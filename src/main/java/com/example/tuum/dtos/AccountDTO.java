package com.example.tuum.dtos;

import java.util.List;

public class AccountDTO {
    private Long CustomerId;
    private String country;
    private List<String> currencies;

    public AccountDTO() {

    }

    public AccountDTO(Long customerId, String country, List<String> currencies) {
        CustomerId = customerId;
        this.country = country;
        this.currencies = currencies;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
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
