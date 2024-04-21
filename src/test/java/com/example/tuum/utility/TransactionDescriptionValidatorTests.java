package com.example.tuum.utility;

import com.example.tuum.exceptions.InvalidTransactionDescriptionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionDescriptionValidatorTests {
    @Test
    public void testValidateTransactionDescription_ValidDescription() {
        assertDoesNotThrow(() -> TransactionDescriptionValidator.validateTransactionDescription("Payment"));
    }

    @Test
    public void testValidateTransactionDescription_EmptyDescription() {
        assertThrows(InvalidTransactionDescriptionException.class, () -> TransactionDescriptionValidator.validateTransactionDescription(""));
    }
}
