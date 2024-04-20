package com.example.tuum.converters;

import com.example.tuum.domain.Balance;
import com.example.tuum.domain.Transaction;
import com.example.tuum.dtos.CreateTransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionToCreateTransactionDtoConverter {

    public CreateTransactionDto convertTransactionToCreateTransactionDTO(Transaction transaction, Balance balance) {
        return new CreateTransactionDto(
                transaction.getId(),
                balance.getAccountId(),
                transaction.getTransactionAmount(),
                balance.getCurrency(),
                transaction.getDirectionOfTransaction(),
                transaction.getTransactionDescription(),
                balance.getAvailableAmount()
        );
    }
}
