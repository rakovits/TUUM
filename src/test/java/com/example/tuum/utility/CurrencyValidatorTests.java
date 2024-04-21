package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidCurrencyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurrencyValidatorTests {
    @Test
    public void testValidateCurrency_ValidCurrency() {
        assertDoesNotThrow(() -> CurrencyValidator.validateCurrency("EUR"));
        assertDoesNotThrow(() -> CurrencyValidator.validateCurrency("SEK"));
        assertDoesNotThrow(() -> CurrencyValidator.validateCurrency("GBP"));
        assertDoesNotThrow(() -> CurrencyValidator.validateCurrency("USD"));
    }

    @Test
    public void testValidateCurrency_InvalidCurrency() {
        assertThrows(InvalidCurrencyException.class, () -> CurrencyValidator.validateCurrency("AUD"));
        assertThrows(InvalidCurrencyException.class, () -> CurrencyValidator.validateCurrency("JPY"));
        assertThrows(InvalidCurrencyException.class, () -> CurrencyValidator.validateCurrency("CAD"));
    }

}
