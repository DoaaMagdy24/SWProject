package com.example.demo.Services;

import com.example.demo.Controllers.LogedIn;
import com.example.demo.Repositories.DonationRepo;
import com.example.demo.Repositories.LoanRepo;
import com.example.demo.Repositories.PaymentRepo;
import com.example.demo.Repositories.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private LoanRepo loanRepository;
    @Autowired
    private TransferRepo transferRepository;
    @Autowired
    private DonationRepo donateRepository;
    @Autowired
    private PaymentRepo paymentRepository;
    @Autowired
    private LogedIn theUser;

    public List<Object> getAllTransactions() {
        // fetch all transactions from all entities
        List<Object> transactions = new ArrayList<>();
        transactions.addAll(loanRepository.findAll());
        transactions.addAll(transferRepository.findAll());
        transactions.addAll(donateRepository.findAll());
        transactions.addAll(paymentRepository.findAll());
        return transactions;
    }

    public List<Object> getTransactionsForCurrentUser() {
        Integer userId = theUser.getCurrentUser().getId();
        // fetch transactions for the current user from all entities
        List<Object> transactions = new ArrayList<>();
        transactions.addAll(loanRepository.findByUserId(userId));
        transactions.addAll(transferRepository.findByUserId(userId));
        transactions.addAll(donateRepository.findByUserId(userId));
        transactions.addAll(paymentRepository.findByUserId(userId));
        return transactions;
    }

    public List<Object> getTransactionsByType(String type) {
        // fetch transactions by type from all entities
        List<Object> transactions = new ArrayList<>();
        if(Objects.equals(type, "loan")){transactions.addAll(loanRepository.findAll());}
        if(Objects.equals(type, "transfer")){transactions.addAll(transferRepository.findAll());}
        if(Objects.equals(type, "donate")){transactions.addAll(donateRepository.findAll());}
        if(Objects.equals(type, "payment")){transactions.addAll(paymentRepository.findAll());}
        return transactions;
    }

    public List<Object> getTransactionsByTypeForCurrentUser(String type) {
        Integer userId = theUser.getCurrentUser().getId();
        // fetch transactions by type for the current user from all entities
        List<Object> transactions = new ArrayList<>();
        if(Objects.equals(type, "loan")){transactions.addAll(loanRepository.findByUserId(userId));}
        if(Objects.equals(type, "transfer")){transactions.addAll(transferRepository.findByUserId(userId));}
        if(Objects.equals(type, "donate")){transactions.addAll(donateRepository.findByUserId(userId));}
        if(Objects.equals(type, "payment")){transactions.addAll(paymentRepository.findByUserId(userId));}
        return transactions;
    }
}