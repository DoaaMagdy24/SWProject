package com.example.demo.Repositories;

import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<user,Integer> {
    user findByEmail(String email) ;
    void deleteByEmail(String email);
}
