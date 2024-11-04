package com.EmployeeManagementSystem.EMS.Controller.employee_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Service.employee_service.EmpService;

@Controller
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @GetMapping("/employee_login")
    public String showEmployeeLoginPage() {
        return "employee_login";
    }

    @PostMapping("/employee/authenticate")
    public String authenticateEmployee(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        Model model
    ) {
        // Check if the name exists in the Employee table and if the email matches
        boolean isAuthenticated = empService.verifyEmployee(name, email);
        if (isAuthenticated) {
            return "redirect:/employee_dashboard";  // Redirect to employee dashboard
        }
        model.addAttribute("error", "Invalid name or email.");
        return "employee_login";  // Redirect back to login page on failure
    }

    @GetMapping("/employee_dashboard")
    public String employeeDashboard(Model model) {
        // Fetch employee data to populate the dashboard
        return "employee_dashboard"; // Name of the HTML file without extension
    }
}
