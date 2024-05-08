package com.example.demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loan")
public class Loan {

        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(nullable = false)
        private String customerAccountNumber;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        @NotNull(message = "Customer is required")
        private user customerId;

        @ManyToOne
        @JoinColumn(name = "loan_type_id")
        private LoanType loanType;

        @NotNull(message = "Loan amount is required")
        @DecimalMin(value = "1000", message = "Loan amount must be at least 1000")
        @Column(name ="amount")
        private BigDecimal loanAmount;

        @NotNull(message = "Interest rate is required")
        @DecimalMin(value = "0.01", message = "Interest rate must be at least 0.01")
        @Column(name ="interest_rate")
        private BigDecimal interestRate;

        @NotNull(message = "Loan duration is required")
        @Min(value = 6, message = "Loan duration must be at least 6 months")
        @Column(name = "duration_months")
        private Integer durationMonths;

        @NotNull(message = "Start date is required")
        @Column(name = "start_date")
        private LocalDate startDate;

        @NotNull(message = "Status is required")
        @Size(min = 1, max = 10, message = "Status must be between 1 and 10 characters")
        @Column(name = "status")
        private String status;


    }

