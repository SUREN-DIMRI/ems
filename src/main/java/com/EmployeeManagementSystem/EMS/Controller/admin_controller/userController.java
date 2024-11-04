package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

//import com.EmployeeManagementSystem.EMS.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Service.admin_service.userService;

@Controller
public class userController {
    
    @Autowired
    private userService loginService;

    @GetMapping("/admin/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isValid = loginService.validateUser(username, password);
        if (isValid) {
            return "redirect:/admin/dashboard";  // Redirect to welcome page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on the login page if the login fails
        }
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "dashboard"; // Return the dashboard.html view
    }
}
