package com.EmployeeManagementSystem.EMS.Controller.tl_Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Entity.tl_entity.task;
import com.EmployeeManagementSystem.EMS.Service.tl_service.TLManagementService;

@Controller
public class TlController {
    
    @Autowired
    private TLManagementService tlManagementService;

    @GetMapping("/tl_login")
    public String showTlLoginPage() {
        return "tl_login"; // Ensure this matches your HTML file name
    }
    
    @PostMapping("/tl/authenticate")
    public String authenticateTL(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        boolean isAuthenticated = tlManagementService.verifyTL(username, password);
        if (isAuthenticated) {
            return "redirect:/tl_dashboard"; // Redirect to TL dashboard upon successful login
        }
        model.addAttribute("error", "Invalid username or password.");
        return "tl_login"; // Return to the login page on error
    }

    @GetMapping("/tl_dashboard")
    public String tlDashboard(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        } else {
            System.out.println("Principal is null, user is not authenticated");
        }
    
        return "tl_dashboard";
    }
}
