package com.example.demo.Services;

import com.example.demo.Controllers.LogedIn;
//import com.example.demo.DTO.AdminMapper;
import com.example.demo.Entities.Admin;
import com.example.demo.Repositories.AdminRepo;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Entities.user;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Transactional
@Service
public class AdminService {
    private static final Log log = LogFactory.getLog(AdminService.class);
    @Autowired
    private AdminRepo adminRepository;

    @Autowired
    private UserRepository userRepository;
   // private AdminMapper adminMapper;
    @Autowired
    private LogedIn theUser;
    @Autowired
    private LogedIn theAdmin;

    public List<Admin> getAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
        log.info("Admin deleted successfully: " + userRepository.findById(id));
    }

    public String modifyUser(Integer id, String newName, String newEmail, String newPassword) {
        Optional<user> user= userRepository.findById(id);
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return modifyAdmin(id,newName,newEmail,newPassword);
        } else if (user.isPresent()) {
            return modify_user(id,newName,newEmail,newPassword);
        } else {
            return "Invalid user";
        }
    }

    private String modifyAdmin (Integer id, String newName, String newEmail, String newPassword) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            Admin adminEntity = admin.get();
            adminEntity.setName(newName);
            adminEntity.setEmail(newEmail);
            adminEntity.setPassword(newPassword);
            adminRepository.save(adminEntity);
            return "Admin User modified successfully.";
        }
        return "Admin not found";
    }

    private String modify_user(Integer id, String newName, String newEmail, String newPassword) {
        Optional<user> user = userRepository.findById(id);
        if (user.isPresent()) {
            user userEntity = user.get();
            userEntity.setName(newName);
            userEntity.setEmail(newEmail);
            userEntity.setPassword(newPassword);
            userRepository.save(userEntity);
            return "User modified successfully.";
        }
        return "User not found";
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }

    public Admin findByEmail(String email) {
        log.info("Fetching admin by email: " + adminRepository.findByEmail(email));
        return adminRepository.findByEmail(email);
    }
}