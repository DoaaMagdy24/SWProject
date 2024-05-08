package com.example.demo.Repositories;

import com.example.demo.Entities.Payments;
import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface PaymentRepo extends JpaRepository<Payments,Long> {
    Collection<user> findByUserId(Integer userId);
}
