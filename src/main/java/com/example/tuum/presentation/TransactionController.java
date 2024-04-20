package com.example.tuum.presentation;

import com.example.tuum.converters.TransactionToCreateTransactionDtoConverter;
import com.example.tuum.converters.TransactionToTransactionDtoConverter;
import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.CreateTransactionDto;
import com.example.tuum.dtos.TransactionDto;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.service.BalanceService;
import com.example.tuum.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final BalanceService balanceService;
    private final TransactionToCreateTransactionDtoConverter transactionToCreateTransactionDtoConverter;

    private final TransactionToTransactionDtoConverter transactionToTransactionDtoConverter;

    @Autowired
    public TransactionController(TransactionService transactionService, BalanceService balanceService, TransactionToCreateTransactionDtoConverter transactionToCreateTransactionDtoConverter, TransactionToTransactionDtoConverter transactionToTransactionDtoConverter) {
        this.transactionService = transactionService;
        this.balanceService = balanceService;
        this.transactionToCreateTransactionDtoConverter = transactionToCreateTransactionDtoConverter;
        this.transactionToTransactionDtoConverter = transactionToTransactionDtoConverter;
    }

    @PostMapping("/")
    public ResponseEntity<CreateTransactionDto> createTransaction(@RequestBody CreateTransactionCommand createTransactionCommand) throws InvalidResourceFieldException {
        Transaction transaction = transactionService.createTransaction(
                createTransactionCommand.getAccountId(),
                createTransactionCommand.getTransactionAmount(),
                createTransactionCommand.getCurrency(),
                createTransactionCommand.getDirectionOfTransaction(),
                createTransactionCommand.getTransactionDescription());

        Balance balance = balanceService.getBalanceByAccountIdAndCurrency(createTransactionCommand.getAccountId(), createTransactionCommand.getCurrency());

        CreateTransactionDto createTransactionDTO = transactionToCreateTransactionDtoConverter.convertTransactionToCreateTransactionDTO(transaction, balance);

        return new ResponseEntity<>(createTransactionDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountId(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);

        List<TransactionDto> transactionDtos = new ArrayList<>();

        for (Transaction transaction: transactions) {
            Balance balance = balanceService.getBalanceById(transaction.getBalanceId());
            transactionDtos.add(transactionToTransactionDtoConverter.convertTransactionToTransactionDTO(transaction, balance));
        }

        return new ResponseEntity<>(transactionDtos, HttpStatus.CREATED);
    }


}
