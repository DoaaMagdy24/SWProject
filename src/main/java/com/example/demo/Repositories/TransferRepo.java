package com.example.demo.Repositories;

import com.example.demo.Entities.Transfer;
import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {
    Collection<user> findByUserId(Integer userId);
}
