package com.example.demo.Controllers;

import com.example.demo.Entities.Admin;
import com.example.demo.Entities.user;
import com.example.demo.Services.AdminService;
import com.example.demo.Services.UserService;
//import com.example.demo.Entities.RoleEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private LogedIn theUser;
    @Autowired
    private LogedIn theAdmin;

    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsersAndAdmins(HttpServletRequest request) {
        if (isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }
        try {
            List<user> users = userService.getAllUsers();

            List<Admin> admins = adminService.getAllAdmins();

            List<Object> result = new ArrayList<>();
            result.addAll(users);
            result.addAll(admins);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching data");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(HttpServletRequest request, @RequestBody Integer id) {
        if (isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modify")
    public String modifyUser(HttpServletRequest request, @RequestBody Integer id,
                             @RequestBody String newName, @RequestBody String nemEmail,
                             @RequestBody String newPassword) {
        if (isAdmin(request)) {
            return "Not authorized";
        }
        HttpSession session = request.getSession(false);

        return adminService.modifyUser(id,newName,nemEmail, newPassword);
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
        if (isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Admin savedUser = adminService.createAdmin(admin);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id, HttpServletRequest request) {
        if (isAdmin(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return true;
        }
        String role = (String) session.getAttribute("role");
        return role == null || !role.equals("admin");
    }

    @GetMapping("/email")
    public ResponseEntity<Object> getAdmin() {
        try {
            Admin admin= this.theAdmin.getCurrentAdmin();
            if (admin!= null) {
                return ResponseEntity.ok(admin);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}