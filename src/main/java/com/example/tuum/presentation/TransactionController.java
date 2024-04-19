package com.example.tuum.presentation;

import com.example.tuum.converters.TransactionToTransactionDtoConverter;
import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.TransactionDTO;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.service.BalanceService;
import com.example.tuum.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final BalanceService balanceService;
    private final TransactionToTransactionDtoConverter transactionToTransactionDtoConverter;

    @Autowired
    public TransactionController(TransactionService transactionService, BalanceService balanceService, TransactionToTransactionDtoConverter transactionToTransactionDtoConverter) {
        this.transactionService = transactionService;
        this.balanceService = balanceService;
        this.transactionToTransactionDtoConverter = transactionToTransactionDtoConverter;
    }

    @PostMapping("/")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody CreateTransactionCommand createTransactionCommand) throws InvalidResourceFieldException {
        Transaction transaction = transactionService.createTransaction(
                createTransactionCommand.getAccountId(),
                createTransactionCommand.getTransactionAmount(),
                createTransactionCommand.getCurrency(),
                createTransactionCommand.getDirectionOfTransaction(),
                createTransactionCommand.getTransactionDescription());

        Balance balance = balanceService.getBalanceByAccountIdAndCurrency(createTransactionCommand.getAccountId(), createTransactionCommand.getCurrency());

        TransactionDTO transactionDTO = transactionToTransactionDtoConverter.convertTransactionToTransactionDTO(transaction, balance);

        return new ResponseEntity<>(transactionDTO, HttpStatus.CREATED);
    }
}
