package com.example.tuum.presentation;

import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.TransactionDTO;
import com.example.tuum.exceptions.InvalidResourceFieldException;
import com.example.tuum.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws InvalidResourceFieldException {
        Transaction transaction = transactionService.createTransaction(
                transactionDTO.getAccountId(),
                transactionDTO.getTransactionAmount(),
                transactionDTO.getCurrency(),
                transactionDTO.getDirectionOfTransaction(),
                transactionDTO.getTransactionDescription());

        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
