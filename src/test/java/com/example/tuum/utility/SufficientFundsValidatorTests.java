package com.example.tuum.utility;

import com.example.tuum.domain.Balance;
import com.example.tuum.exceptions.InsufficientFundsException;
import com.example.tuum.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SufficientFundsValidatorTests {
    @Mock
    private BalanceService balanceService;

    @Test
    public void testValidateSufficientFunds_InsufficientFunds() {
        Balance insufficientBalance = new Balance();
        insufficientBalance.setAvailableAmount(50.0);
        when(balanceService.getBalanceByAccountIdAndCurrency(anyLong(), eq("USD"))).thenReturn(insufficientBalance);

        assertThrows(InsufficientFundsException.class, () -> SufficientFundsValidator.validateSufficientFunds(1L, 100.0, "USD", "OUT", balanceService));
    }

    @Test
    public void testValidateSufficientFunds_SufficientFunds() {
        Balance sufficientBalance = new Balance();
        sufficientBalance.setAvailableAmount(150.0);
        when(balanceService.getBalanceByAccountIdAndCurrency(anyLong(), eq("USD"))).thenReturn(sufficientBalance);

        assertDoesNotThrow(() -> SufficientFundsValidator.validateSufficientFunds(1L, 100.0, "USD", "OUT", balanceService));
    }
}
