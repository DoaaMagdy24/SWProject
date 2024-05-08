package com.example.demo.Services;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Entities.Account;
import com.example.demo.Entities.Transfer;
import com.example.demo.Repositories.TransferRepo;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    private TransferRepo transferRepo;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }



    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    //    @Override
//    public AccountDto transfer(Long sourceAccountId, Long targetAccountId, double amount) {
//        Account sourceAccount = accountRepository.findById(sourceAccountId)
//                .orElseThrow(() -> new RuntimeException("Source account not found"));
//
//        if (sourceAccount.getBalance() < amount) {
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        Account targetAccount = accountRepository.findById(targetAccountId)
//                .orElseThrow(() -> new RuntimeException("Target account not found"));
//
//        double sourceBalanceAfterTransfer = sourceAccount.getBalance() - amount;
//        sourceAccount.setBalance(sourceBalanceAfterTransfer);
//
//        double targetBalanceAfterTransfer = targetAccount.getBalance() + amount;
//        targetAccount.setBalance(targetBalanceAfterTransfer);
//
//        // Save changes within a transaction
//        Account savedSourceAccount = accountRepository.save(sourceAccount);
//        Account savedTargetAccount = accountRepository.save(targetAccount);
//
//        return AccountMapper.mapToAccountDto(savedSourceAccount);
//    }
    @Override
    public AccountDto transfer(Long sourceAccountId, Long targetAccountId, double amount) {
        // Withdraw from source account
        AccountDto sourceAccountDto = withdraw(sourceAccountId, amount);

        // Deposit into target account
        deposit(targetAccountId, amount);

//        Transfer save = this.transferRepo.save(new Transfer(sourceAccountId, targetAccountId, amount));

        return sourceAccountDto;
    }

}