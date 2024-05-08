package com.example.demo.Controllers;

import com.example.demo.DTO.UserDto;
import com.example.demo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public String saveUser(@RequestBody() @Valid UserDto data) {
        this.userService.signup(data);
        return "register";
    }
}
