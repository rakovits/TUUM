package com.example.tuum.converters;

import com.example.tuum.domain.Account;
import com.example.tuum.domain.BalanceFields;
import com.example.tuum.dtos.AccountDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountToAccountDtoConverterTests {
    @Test
    public void testConvertAccountToAccountDto() {
        AccountToAccountDtoConverter converter = new AccountToAccountDtoConverter();

        Account account = new Account();
        account.setCustomerId(456L);
        account.setCountry("US");

        List<BalanceFields> balances = new ArrayList<>();
        balances.add(new BalanceFields(100.0, "USD"));
        balances.add(new BalanceFields(200.0, "EUR"));

        AccountDto accountDto = converter.convertAccountToAccountDto(account, balances);

        assertEquals(account.getCustomerId(), accountDto.getCustomerId());
        assertEquals(balances, accountDto.getBalances());
    }
}
