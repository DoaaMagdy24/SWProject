package com.example.demo.Repositories;

import com.example.demo.Entities.Loan;
import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface LoanRepo extends JpaRepository<Loan,Long> {
    Collection<user> findByUserId(Integer userId);
}
