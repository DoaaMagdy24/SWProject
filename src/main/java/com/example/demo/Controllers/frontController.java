package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class frontController {

    AdminController adminController;
    @GetMapping("/admin-page")
    public String admainPage() {
        return ("admin-page");
    }
    @GetMapping("/show-customers")
    public ModelAndView showCustomers() {
        return new ModelAndView("show_customer");
    }
    /*
    public Admin getAllUsers(){

        return adminController.getAllUsersAndAdmins();
    }*/
}
