package com.example.tuum.dtos;

import com.example.tuum.domain.BalanceFields;

import java.util.List;

public class AccountDto {

    private Long accountId;
    private Long customerId;
    private List<BalanceFields> balances;

    public AccountDto(Long accountId, Long customerId, List<BalanceFields> balances) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balances = balances;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<BalanceFields> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceFields> balances) {
        this.balances = balances;
    }
}
