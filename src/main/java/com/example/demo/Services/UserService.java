package com.example.demo.Services;

import com.example.demo.DTO.UserDto;
import com.example.demo.Entities.Admin;
import com.example.demo.Repositories.AdminRepo;
import com.example.demo.Entities.user;
import com.example.demo.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    private AdminRepo adminRepo;
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


    public void signup(UserDto userDto) {
        String role = null;
        if(userDto.getPassword().matches(".+\\\\.admin$")){
            role = "admin";
            Admin admin = new Admin(userDto.getName(), userDto.getEmail(), userDto.getPassword(),role);
            adminRepo.save(admin);
        }else {
            role = "customer";
            user user = new user(userDto.getName(), userDto.getEmail(), userDto.getPassword(), userDto.getAccountNumber(), userDto.getNationalId(), role);
            userRepository.save(user);
        }
    }
}