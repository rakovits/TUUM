package com.example.tuum.converters;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.TransactionDTO;
import org.springframework.stereotype.Component;

@Component
public class TransactionToTransactionDtoConverter {

    public TransactionDTO convertTransactionToTransactionDTO(Transaction transaction, Balance balance) {
        return new TransactionDTO(
                transaction.getId(),
                balance.getAccountId(),
                transaction.getAmount(),
                balance.getCurrency(),
                transaction.getDirectionOfTransaction(),
                transaction.getTransactionDescription(),
                balance.getAvailableAmount()
        );
    }
}
