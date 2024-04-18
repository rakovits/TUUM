package com.example.tuum.presentation;

import com.example.tuum.domain.Account;
import com.example.tuum.dtos.AccountDTO;
import com.example.tuum.exceptions.AccountNotFoundException;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) throws InvalidResourceFieldException {
        Account account = accountService.createAccount(accountDTO.getCustomerId(), accountDTO.getCountry(), accountDTO.getCurrencies());
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) throws AccountNotFoundException {
        Account account = accountService.getAccountById(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
