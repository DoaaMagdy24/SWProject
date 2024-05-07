package com.example.demo.Controllers;

import com.example.demo.DTO.AdminDTO;
import com.example.demo.DTO.UserDto;
import com.example.demo.Services.UserService;
import com.example.demo.Entities.user;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<user> addUser(@Valid @RequestBody user user) {
        user savedUser = userService.addUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser
            (@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        userDto.setId(id);
        user updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    public String adminResource(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            AdminDTO admin = (AdminDTO) session.getAttribute("admin");
            if (admin != null) {
                return "admin resource";
            } else {
                return "login first";
            }
        }
        else{
            return "login first";
        }
    }
}
