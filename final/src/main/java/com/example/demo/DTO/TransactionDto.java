//package com.example.demo.DTO;
//
//import com.example.demo.entities.TransactionType;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Positive;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class TransactionDto {
//
//    private Long id;
//
//    @NotBlank(message = "User ID is required")
//    private String userId;
//
//    @NotNull(message = "Transaction type is required")
//    @Enumerated(EnumType.STRING)
//    private TransactionType type;
//
//    @NotNull(message = "Amount is required")
//    @Positive(message = "Amount must be positive")
//    private Double amount;
//
//    @NotBlank(message = "Status is required")
//    @Pattern(regexp = "success|failure", message = "Status must be either 'success' or 'failure'")
//    private String status;
//
//    @NotNull(message = "Timestamp is required")
//    private LocalDateTime timestamp;
//}
