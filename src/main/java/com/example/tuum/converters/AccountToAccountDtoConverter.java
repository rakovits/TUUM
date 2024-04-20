package com.example.tuum.converters;

import com.example.tuum.domain.Account;
import com.example.tuum.domain.BalanceFields;
import com.example.tuum.dtos.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountToAccountDtoConverter {

    public AccountDto convertAccountToAccountDto(Account account, List<BalanceFields> balances) {
        return new AccountDto(
                account.getId(),
                account.getCustomerId(),
                balances
        );
    }
}
