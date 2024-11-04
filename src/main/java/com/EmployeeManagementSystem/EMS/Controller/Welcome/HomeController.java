package com.EmployeeManagementSystem.EMS.Controller.Welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Display the welcome page
    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }

    // Handle form submission
    @PostMapping("/verifyCode")
    public String verifyCode(
        @RequestParam("role") String role,
        @RequestParam("code") String code,
        Model model
    ) {
        // Define codes for each role
        String adminCode = "admin@admin";
        String hrCode = "hr@hr";
        String tlCode = "tl@tl";
        String employeeCode = "emp@emp";

        // Check the entered code based on the selected role
        switch (role) {
            case "admin":
                if (code.equals(adminCode)) {
                    return "redirect:/admin/login"; // Replace with actual admin login URL
                }
                break;
            case "hr":
                if (code.equals(hrCode)) {
                    return "redirect:/hr_login"; // Replace with actual HR login URL
                }
                break;
            case "tl":
                if (code.equals(tlCode)) {
                    return "redirect:/tl_login"; // Replace with actual TL login URL
                }
                break;
            case "employee":
                if (code.equals(employeeCode)) {
                    return "redirect:/employee_login"; // Replace with actual Employee login URL
                }
                break;
            default:
                break;
        }

        // If the code is incorrect, add error message and return to the welcome page
        model.addAttribute("error", "Invalid code. Please try again.");
        return "welcome";
    }
}
