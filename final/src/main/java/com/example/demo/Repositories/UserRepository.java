package com.example.demo.Repositories;

import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user,Long> {
    user findByEmail(String email);
    void deleteByEmail(String email);
}
