package com.EmployeeManagementSystem.EMS.Controller.HR_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Service.admin_service.EmployeeService;
import com.EmployeeManagementSystem.EMS.Service.hr_service.HRManagementService;
 // Import your EmployeeService

@Controller
public class HrController {

    @Autowired
    private HRManagementService hrManagementService;

    @Autowired
    private EmployeeService employeeService; // Autowire the EmployeeService

    @GetMapping("/hr_login")
    public String showHrLoginPage() {
        return "hr_login";
    }

    @PostMapping("/hr/authenticate")
    public String authenticateHR(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        // Check if the username exists in the HR table and password matches email
        boolean isAuthenticated = hrManagementService.verifyHR(username, password);
        if (isAuthenticated) {
            return "redirect:/hr_dashboard";  // Redirect to HR dashboard upon successful login
        }
        model.addAttribute("error", "Invalid username or password.");
        return "hr_login";
    }

    @GetMapping("/hr_dashboard")
    public String hrDashboard(Model model) {
        // Fetch employee data to populate the dashboard
        model.addAttribute("employees", employeeService.getAllEmployees()); // Assuming this method returns the list of employees
        model.addAttribute("totalEmployees", employeeService.getTotalEmployees()); // Total employees
        model.addAttribute("totalDepartments", hrManagementService.getTotalDepartments()); // Fetch total departments if you have that service
        
        return "hr_dashboard"; // Name of the HTML file without extension
    }
}
