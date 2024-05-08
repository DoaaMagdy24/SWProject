package com.example.demo.mapper;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Entities.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getNumber(),
                accountDto.getBalance(),
                accountDto.getCustomer_id()
        );

        return account;
    }

//    public static AccountDto mapToAccountDto(Account account) {
//        AccountDto accountDto = new AccountDto(
//                account.getId(),
//                account.getNumber(),
//                account.getBalance(),
//                account.getCustomer_id()
//        );
//        return accountDto;
//
//    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getNumber(),
                account.getBalance(),
                account.getCustomer_id()
        );
        return accountDto;

    }
}

