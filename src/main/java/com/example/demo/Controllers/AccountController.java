package com.example.demo.Controllers;

import com.example.demo.DTO.AccountDto;
import com.example.demo.Entities.Account;
import com.example.demo.Repositories.AccountRepo;
import com.example.demo.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{sourceAccountId}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long sourceAccountId,@RequestBody Map<String, Object> transferRequest)
    {
        Long id = Long.valueOf(transferRequest.get("id").toString());
        Double amount = Double.valueOf(transferRequest.get("amount").toString());
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{sourceAccountId}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long sourceAccountId,@RequestBody Map<String, Object> transferRequest){
        Long id = Long.valueOf(transferRequest.get("id").toString());
        Double amount = Double.valueOf(transferRequest.get("amount").toString());
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    @PutMapping("/{sourceAccountId}/transfer")
    public ResponseEntity<AccountDto> transfer(@PathVariable Long sourceAccountId,
                                               @RequestBody Map<String, Object> transferRequest) {
        Long sourceId = Long.valueOf(transferRequest.get("sourceId").toString());
        Long targetId = Long.valueOf(transferRequest.get("targetId").toString());
        Double amount = Double.valueOf(transferRequest.get("amount").toString());

        AccountDto accountDto = accountService.transfer(sourceId, targetId, amount);
        return ResponseEntity.ok(accountDto);
    }

//    @PostMapping("/getAccount")
//    public Account getTheAccount(@RequestBody String acc_num) {
//        Account acc = accountService.FindByNumber(acc_num);
//        return acc;
//        //        return new ResponseEntity<>(accountService.createAccount(acc_num), HttpStatus.CREATED);
//    }


}

