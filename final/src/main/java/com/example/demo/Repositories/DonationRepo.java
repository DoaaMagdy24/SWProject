package com.example.demo.Repositories;

import com.example.demo.Entities.Donations;
import com.example.demo.Entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donations,Long> {
}
