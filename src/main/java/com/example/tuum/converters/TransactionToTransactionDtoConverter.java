package com.example.tuum.converters;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionToTransactionDtoConverter {

    public TransactionDto convertTransactionToTransactionDTO(Transaction transaction, Balance balance) {
        return new TransactionDto(
                transaction.getId(),
                balance.getAccountId(),
                transaction.getTransactionAmount(),
                balance.getCurrency(),
                transaction.getDirectionOfTransaction(),
                transaction.getTransactionDescription()
        );
    }
}
