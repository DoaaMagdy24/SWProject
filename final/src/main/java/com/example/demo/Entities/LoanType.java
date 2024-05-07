package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "loan_type")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanTypeId;

    @Column(name = "name")
    private String name;


    @Column(name ="interest_rate")
    private BigDecimal interestRate;

    @Column(name = "max_amount")
    private BigDecimal maxAmount;

    @Column(name = "min_amount")
    private BigDecimal minAmount;

    @Column(name = "max_duration_months")
    private Integer maxDurationMonths;

    @Column(name = "min_duration_months")
    private Integer minDurationMonths;


    public LoanType(String name) {
        this.name = name;
    }

    public LoanType() {

    }


    public LoanType(Long loanTypeId, String name) {
        this.loanTypeId = loanTypeId;
        this.name = name;
    }

}

