package com.example.demo.Repositories;

import com.example.demo.Entities.Problem;
import com.example.demo.Entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepo extends JpaRepository<Problem,Long> {
}
