package com.example.demo.Services;
/*
import com.example.demo.DTO.TransactionDto;
import com.example.demo.DTO.TransactionMapper;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.TransactionType;
import com.example.demo.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionMapper transactionMapper;

    public List<TransactionDto> getAllTransactions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (hasAdminRole(authentication)) {
            return getTransactions(transactionRepository.findAll());
        } else {
            Long userId = getCurrentUserId(authentication);
            return getTransactions(transactionRepository.findByUserId(String.valueOf(userId)));
        }
    }

    public List<TransactionDto> getTransactionsByType(TransactionType transactionType) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = getCurrentUserId(authentication);
        if (hasAdminRole(authentication)) {
            return transactionType!= null? getTransactions(transactionRepository.findByType(transactionType)) :
                    getTransactions(transactionRepository.findAll());
        } else {
            return transactionType!= null? getTransactions(transactionRepository.findByUserIdAndType(String.valueOf(userId), transactionType)) :
                    getTransactions(transactionRepository.findByUserId(String.valueOf(userId)));
        }
    }

    private List<TransactionDto> getTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

}*/