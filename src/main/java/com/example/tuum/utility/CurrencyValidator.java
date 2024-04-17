package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidCurrencyException;

import java.util.List;

public class CurrencyValidator {
    public static void validateCurrency(String currency) {
        List<String> validCurrencies = List.of("EUR", "SEK", "GBP", "USD");

        if (!validCurrencies.contains(currency)) {
            throw new InvalidCurrencyException("Invalid currency: " + currency + ".");
        }
    }
}
