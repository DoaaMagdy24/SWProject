package com.example.demo.Services;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Entities.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    AccountDto transfer(Long sourceAccountId, Long targetAccountId, double amount);

}