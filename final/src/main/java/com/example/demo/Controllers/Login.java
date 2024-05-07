package com.example.demo.Controllers;

import com.example.demo.DTO.AdminDTO;
import com.example.demo.DTO.LoginDto;
import com.example.demo.Repositories.AdminRepo;
import com.example.demo.Repositories.UserRepository;
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

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class Login {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    private static final String USERNAME_SESSION_ATTRIBUTE = "username";
    private static final String ROLE_SESSION_ATTRIBUTE = "role";

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session != null) {

            user user = (userService.findByEmail(loginDto.getEmail()));
            Admin admin = adminService.findByEmail(loginDto.getEmail());
            if (Objects.equals(loginDto.getEmail(), user.getEmail())) {
                    //UserDto user = validateUser(loginDto);
                    session.setAttribute("username", user.getName());
                    session.setAttribute("role", "user");
                    System.out.println("user logged in successfully");
                    return "user resource";
                }
                else if (Objects.equals(loginDto.getEmail(), admin.getEmail())) {
                    //AdminDTO admin = validateAdmin(loginDto);
                    session.setAttribute("username", admin.getName());
                    session.setAttribute("role", "admin");
                    System.out.println("admin logged in successfully");
                    return "admin resource";
                }
            else {
                System.out.println("invalid entity");
                return "invalid entity";
            }
        } else {
            System.out.println("Failed to create session");
            return "Failed to create session";
        }
    }

   /*private boolean validateUser(LoginDto loginDto) {
       user user = (userService.findByEmail(loginDto.getEmail()));
        if(loginDto.getEmail().equals(user.getEmail())
                && loginDto.getPassword().equals(user.getPassword())) {
            System.out.println("user valid");
            return true;
        }
        else {
            System.out.println("invalid user");
            return false;
        }
    }

    private boolean validateAdmin(LoginDto loginDto) {
        Admin Admin = adminService.findByEmail(loginDto.getEmail());
        if(loginDto.getEmail().equals(Admin.getEmail())
                && loginDto.getPassword().equals(Admin.getPassword())) {
            System.out.println("admin valid");
            return true;
        }
        else {
            System.out.println("invalid admin");
            return false;
        }*/
}
