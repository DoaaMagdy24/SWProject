package com.example.demo.Controllers;

import com.example.demo.DTO.LoginDto;
import com.example.demo.Services.AdminService;
import com.example.demo.Services.UserService;
import com.example.demo.Entities.Admin;
import com.example.demo.Entities.user;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// LoginController.java
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private LogedIn theUser;
    @Autowired
    private LogedIn theAdmin;

    private static final String USERNAME_SESSION_ATTRIBUTE = "username";
    private static final String ROLE_SESSION_ATTRIBUTE = "role";
    private static final String EMAIL_SESSION_ATTRIBUTE = "email";

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session!= null) {
            if (authenticateUser(loginDto, session)) {
                return "user resource";
            } else if (authenticateAdmin(loginDto, session)) {
                return "admin resource";
            } else {
                return "invalid entity";
            }
        } else {
            return "Failed to create session";
        }
    }

    private boolean authenticateUser(LoginDto loginDto, HttpSession session) {
        user user = userService.findByEmail(loginDto.getEmail());
        if (user!= null && user.getPassword().equals(loginDto.getPassword())) {
            session.setAttribute(USERNAME_SESSION_ATTRIBUTE, user.getName());
            session.setAttribute(EMAIL_SESSION_ATTRIBUTE, user.getEmail());
            session.setAttribute(ROLE_SESSION_ATTRIBUTE, "user");
            this.theUser.setCurrentUser(user);
            return true;
        }
        return false;
    }

    private boolean authenticateAdmin(LoginDto loginDto, HttpSession session) {
        Optional<Admin> adminOptional = Optional.ofNullable(adminService.findByEmail(loginDto.getEmail()));
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(loginDto.getPassword())) {
                this.theAdmin.setCurrentAdmin(admin);
                session.setAttribute(USERNAME_SESSION_ATTRIBUTE, admin.getName());
                session.setAttribute(EMAIL_SESSION_ATTRIBUTE, admin.getEmail());
                session.setAttribute(ROLE_SESSION_ATTRIBUTE, "admin");
                return true;
            }
        }
        return false;
    }
}
