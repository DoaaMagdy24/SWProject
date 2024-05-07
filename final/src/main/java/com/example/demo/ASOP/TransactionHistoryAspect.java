package com.example.demo.ASOP;

//import com.example.demo.DTO.TransactionDto;
//import com.example.demo.Services.TransactionService;
//import com.example.demo.entities.TransactionType;
//import com.example.demo.entities.user;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.time.LocalDateTime;
//
//@Aspect
//@Component
//public class TransactionHistoryAspect {
//    private static final Logger logger = LoggerFactory.getLogger(TransactionHistoryAspect.class);
//
//    private final TransactionService transactionService;
//
//    @Autowired
//    public TransactionHistoryAspect(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
//
//    /**
//     * Captures all create* methods in TransactionService.
//     */
//    @Pointcut("execution(* com.example.demo.Services.TransactionService.addTransaction*(..))")
//    public void createTransactionMethods() {
//    }
//
//
//    private boolean isSupportedTransactionType(Object result) {
//        return result == TransactionType.LOAN || result == TransactionType.TRANSFER || result == TransactionType.DONATE || result == TransactionType.BILL_PAYMENT;
//    }
//
//    private TransactionDto createTransactionDtoFromJoinPoint(JoinPoint joinPoint) {
//        TransactionDto transactionDto = new TransactionDto();
//        transactionDto.setUserId(getUserIdFromJoinPoint(joinPoint));
//        transactionDto.setType(getTransactionTypeFromMethod(joinPoint));
//        transactionDto.setAmount(getAmountFromJoinPoint(joinPoint));
//        transactionDto.setStatus("success");
//        transactionDto.setTimestamp(LocalDateTime.now());
//        return transactionDto;
//    }
//
//    private String getUserIdFromJoinPoint(JoinPoint joinPoint) {
//        return String.valueOf(((user) joinPoint.getArgs()[0]).getId());
//    }
//
//    private @NotNull(message = "Amount is required") @Positive(message = "Amount must be positive") Double getAmountFromJoinPoint(JoinPoint joinPoint) {
//        return (Double) joinPoint.getArgs()[1];
//    }
//
//    private TransactionType getTransactionTypeFromMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        return switch (methodName) {
//            case "createLoan" -> TransactionType.LOAN;
//            case "createTransfer" -> TransactionType.TRANSFER;
//            case "createDonate" -> TransactionType.DONATE;
//            case "createBillPayment" -> TransactionType.BILL_PAYMENT;
//            default -> throw new UnsupportedOperationException("Unsupported transaction type");
//        };
//    }
//}