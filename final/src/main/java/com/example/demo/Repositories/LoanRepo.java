package com.example.demo.Repositories;

import com.example.demo.Entities.Loan;
import com.example.demo.Entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan,Long> {
}
