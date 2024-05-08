package com.example.demo.Repositories;

import com.example.demo.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Integer> {
    void deleteByEmail(String email);
    Admin findByEmail(String email);
}
