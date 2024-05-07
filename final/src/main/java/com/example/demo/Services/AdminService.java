package com.example.demo.Services;

import com.example.demo.DTO.AdminDTO;
//import com.example.demo.DTO.AdminMapper;
import com.example.demo.Entities.Admin;
import com.example.demo.Repositories.AdminRepo;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Entities.user;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private static final Log log = LogFactory.getLog(AdminService.class);
    @Autowired
    private AdminRepo adminRepository;

    @Autowired
    private UserRepository userRepository;
   // private AdminMapper adminMapper;

    public List<Admin> getAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteUser(String email) {
        user user= userRepository.findByEmail(email);
        if (user== null) {
            adminRepository.deleteByEmail(email);
            System.out.println("done");
        } else {
            userRepository.deleteByEmail(email);
            System.out.println("done");
        }
    }

    public String modifyUser(String email) {
        user user= userRepository.findByEmail(email);
        Admin admin = adminRepository.findByEmail(email);
        if (admin!=null) {
            return modifyAdmin(email);
        } else if (user!=null) {
            return modify_user(email);
        } else {
            return "Invalid user";
        }
    }

    private String modifyAdmin(String email) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin!= null) {
            admin.setName(admin.getName());
            admin.setEmail(admin.getEmail());
            admin.setPassword(admin.getPassword());
            adminRepository.save(admin);
            return "Admin User modified successfully.";
        }
        return "Admin not found";
    }

    private String modify_user(String email) {
        // Similar modifications for regular user
        user user = userRepository.findByEmail(email);
        if (user!= null) {
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            userRepository.save(user);
            return "Regular User modified successfully.";
        }
        return "Regular User not found";
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}