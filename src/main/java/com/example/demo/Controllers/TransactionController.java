package com.example.demo.Controllers;

import com.example.demo.Services.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/allTransactions")
    public List<Object> getAllTransactions(HttpServletRequest request) {
        if (isAdmin(request)) {
            return transactionService.getAllTransactions();
        } else {
            return transactionService.getTransactionsForCurrentUser();
        }
    }

    @GetMapping("/{type}")
    public List<Object> getTransactionsByType(@PathVariable String type, HttpServletRequest request) {
        if (isAdmin(request)) {
            return transactionService.getTransactionsByType(type);
        } else {
            return transactionService.getTransactionsByTypeForCurrentUser(type);
        }
    }

    private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return true;
        }
        String role = (String) session.getAttribute("role");
        return role == null || !role.equals("admin");
    }
}