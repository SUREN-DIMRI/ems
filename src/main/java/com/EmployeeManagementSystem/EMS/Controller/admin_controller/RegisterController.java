package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

//import com.EmployeeManagementSystem.EMS.Repository.*;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.UserRepository;
//import com.EmployeeManagementSystem.EMS.Entity.*;
import com.EmployeeManagementSystem.EMS.Entity.admin_entity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    
@Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // Renders register.html
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("Registering user: " + username);
        // Check if username already exists
        if (userRepository.findByUsername(username).isPresent()) {
            return "redirect:/register?error";  // Redirect back with error if username exists
        }

        // Create new user
        user newUser = new user();
        newUser.setUsername(username);
        newUser.setPassword(password);  // You should hash the password in a real application
        userRepository.save(newUser);   // This should insert data into the database

        System.out.println("User registered successfully!");

        return "redirect:/";  // Redirect to login page after successful registration
    }

}
