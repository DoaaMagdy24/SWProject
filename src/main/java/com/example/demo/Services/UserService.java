package com.example.demo.Services;

import com.example.demo.Repositories.AdminRepo;
import com.example.demo.Entities.user;
import com.example.demo.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository, AdminRepo adminRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public user getUserById(Integer id) {

        return userRepository.findById(id).orElse(null);
    }

    public user addUser(@Valid user user) {
        return userRepository.save(user);
    }

    public user updateUser(@Valid user user) {
        user existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public user findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}