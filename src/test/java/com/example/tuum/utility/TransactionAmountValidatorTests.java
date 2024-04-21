package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionAmountValidatorTests {
    @Test
    public void testValidateTransactionAmount_ValidAmount() {
        assertDoesNotThrow(() -> TransactionAmountValidator.validateTransactionAmount(100.0));
        assertDoesNotThrow(() -> TransactionAmountValidator.validateTransactionAmount(50.55));
    }

    @Test
    public void testValidateTransactionAmount_NegativeAmount() {
        assertThrows(InvalidTransactionAmountException.class, () -> TransactionAmountValidator.validateTransactionAmount(-100.0));
    }

    @Test
    public void testValidateTransactionAmount_ZeroAmount() {
        assertThrows(InvalidTransactionAmountException.class, () -> TransactionAmountValidator.validateTransactionAmount(0.0));
    }

    @Test
    public void testValidateTransactionAmount_MoreThanTwoDecimalPlaces() {
        assertThrows(InvalidTransactionAmountException.class, () -> TransactionAmountValidator.validateTransactionAmount(50.555));
    }

    @Test
    public void testHasMaximumTwoDecimalPlaces_ValidAmounts() {
        assert(TransactionAmountValidator.hasMaximumTwoDecimalPlaces(100.0));
        assert(TransactionAmountValidator.hasMaximumTwoDecimalPlaces(50.55));
        assert(TransactionAmountValidator.hasMaximumTwoDecimalPlaces(123456.78));
    }

    @Test
    public void testHasMaximumTwoDecimalPlaces_MoreThanTwoDecimalPlaces() {
        assert(!TransactionAmountValidator.hasMaximumTwoDecimalPlaces(50.555));
    }
}
