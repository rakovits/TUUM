package com.example.tuum.presentation;

import com.example.tuum.converters.AccountToAccountDtoConverter;
import com.example.tuum.domain.Account;
import com.example.tuum.domain.Balance;
import com.example.tuum.domain.BalanceFields;
import com.example.tuum.dtos.AccountDto;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.service.AccountService;
import com.example.tuum.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final BalanceService balanceService;
    private final AccountToAccountDtoConverter accountToAccountDtoConverter;

    @Autowired
    public AccountController(AccountService accountService, BalanceService balanceService, AccountToAccountDtoConverter accountToAccountDtoConverter) {
        this.accountService = accountService;
        this.balanceService = balanceService;
        this.accountToAccountDtoConverter = accountToAccountDtoConverter;
    }

    @PostMapping("/")
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountCommand createAccountCommand) throws InvalidResourceFieldException {
        Account account = accountService.createAccount(createAccountCommand.getCustomerId(), createAccountCommand.getCountry(), createAccountCommand.getCurrencies());

        List<Balance> balances = balanceService.getBalancesByAccountId(account.getId());
        List<BalanceFields> balanceFields = new ArrayList<>();

        for(Balance balance: balances){
            balanceFields.add(new BalanceFields(balance.getAvailableAmount(), balance.getCurrency()));
        }

        AccountDto accountDto = accountToAccountDtoConverter.convertAccountToAccountDto(account, balanceFields);

        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accountId) throws AccountNotFoundException {
        Account account = accountService.getAccountById(accountId);

        List<Balance> balances = balanceService.getBalancesByAccountId(account.getId());
        List<BalanceFields> balanceFields = new ArrayList<>();

        for(Balance balance: balances){
            balanceFields.add(new BalanceFields(balance.getAvailableAmount(), balance.getCurrency()));
        }

        AccountDto accountDto = accountToAccountDtoConverter.convertAccountToAccountDto(account, balanceFields);

        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }
}
