package com.example.demo.Repositories;

import com.example.demo.Entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepo extends JpaRepository<Transfer,Long> {
}
