package com.example.demo.Controllers;

import com.example.demo.Entities.Admin;
import com.example.demo.Entities.user;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LogedIn {
    user CurrentUser;
    Admin CurrentAdmin;

}