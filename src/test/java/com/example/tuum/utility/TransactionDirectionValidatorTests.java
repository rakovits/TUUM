package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionDirectionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionDirectionValidatorTests {
    @Test
    public void testValidateTransactionDirection_ValidDirection() {
        assertDoesNotThrow(() -> TransactionDirectionValidator.validateTransactionDirection("IN"));
        assertDoesNotThrow(() -> TransactionDirectionValidator.validateTransactionDirection("OUT"));
    }

    @Test
    public void testValidateTransactionDirection_InvalidDirection() {
        assertThrows(InvalidTransactionDirectionException.class, () -> TransactionDirectionValidator.validateTransactionDirection("INVALID"));
    }
}
