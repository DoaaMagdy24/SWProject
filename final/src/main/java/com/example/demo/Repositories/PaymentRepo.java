package com.example.demo.Repositories;

import com.example.demo.Entities.Payments;
import com.example.demo.Entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payments,Long> {
}
