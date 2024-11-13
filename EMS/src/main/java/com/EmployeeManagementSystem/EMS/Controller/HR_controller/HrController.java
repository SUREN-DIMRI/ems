package com.EmployeeManagementSystem.EMS.Controller.HR_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Service.admin_service.EmployeeService;
import com.EmployeeManagementSystem.EMS.Service.hr_service.HRManagementService;

@Controller
public class HrController {

    @Autowired
    private HRManagementService hrManagementService;

    @Autowired
    private EmployeeService employeeService; 

    // Displays the HR login page
    @GetMapping("/hr_login")
    public String showHrLoginPage() {
        return "hr_login";
    }

    // Authenticates HR login credentials
    @PostMapping("/hr/authenticate")
    public String authenticateHR(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        boolean isAuthenticated = hrManagementService.verifyHR(username, password);
        if (isAuthenticated) {
            return "redirect:/hr_dashboard";  // Redirect to HR dashboard upon successful login
        }
        model.addAttribute("error", "Invalid username or password.");
        return "hr_login";
    }

    // Displays the HR dashboard with employee and department information
    @GetMapping("/hr_dashboard")
    public String hrDashboard(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees()); // List of all employees
        model.addAttribute("totalEmployees", employeeService.getTotalEmployees()); // Total number of employees
        model.addAttribute("totalDepartments", hrManagementService.getTotalDepartments()); // Total number of departments
        
        return "hr_dashboard"; 
    }

    @PostMapping("/hr/markAttendance")
    public String markAttendance(@RequestParam("employeeId") Long employeeId, 
                                @RequestParam("isPresent") Boolean isPresent, 
                                Model model) {
    boolean isAttendanceMarked = hrManagementService.markAttendance(employeeId, isPresent);

        if (isAttendanceMarked) {
            model.addAttribute("success", "Attendance marked successfully.");
        } else {
            model.addAttribute("error", "Attendance already marked for today.");
        }

        return "redirect:/hr_dashboard";
    }
}
