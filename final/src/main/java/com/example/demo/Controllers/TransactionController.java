//package com.example.demo.Controllers;
//
//import com.example.demo.DTO.TransactionDto;
//import com.example.demo.Services.TransactionService;
//import com.example.demo.entities.TransactionType;
//import org.apache.coyote.BadRequestException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping
//public class TransactionController {
//    @Autowired
//    private TransactionService transactionService;
//
//   @GetMapping("/allTransactions")
//    public List<TransactionDto> getAllTransactions() {
//        return transactionService.getAllTransactions();
//    }
//
//    @GetMapping("/{type}")
//    public List<TransactionDto> getTransactionsByType(@PathVariable TransactionType type) throws BadRequestException {
//        if (type == null) {
//            throw new BadRequestException("Transaction type is required");
//        }
//        return transactionService.getTransactionsByType(type);
//    }
//}