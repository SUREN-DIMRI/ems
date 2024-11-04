package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;
import com.EmployeeManagementSystem.EMS.Service.admin_service.HRService;

@Controller
public class HRController {

    @Autowired
    private HRService hrService;

    @GetMapping("/admin/hr")
    public String getHR(Model model) {
        List<HR> hrList = hrService.getALLHR();
        model.addAttribute("hrList", hrList);
        return "hr"; // This will map to hr.html
    }

    @PostMapping("/addHR")
    public String addHR(
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email
    ) {
        HR newHR = new HR();
        newHR.setName(name);
        newHR.setDepartment(department);
        newHR.setEmail(email);
        hrService.addHR(newHR);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @PostMapping("/update/{id}") // Ensure this path is matched correctly in the HTML
    public String updateHR(
        @PathVariable Long id,
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email
    ) {
        HR updatedHR = new HR();
        updatedHR.setId(id);
        updatedHR.setName(name);
        updatedHR.setDepartment(department);
        updatedHR.setEmail(email);
        hrService.updateHR(updatedHR);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @PostMapping("/hr/delete/{id}")
    public String deleteHR(@PathVariable Long id) {
        hrService.deleteHR(id);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @GetMapping("/hr/editHR/{id}")
    public String editHR(@PathVariable Long id, Model model) {
        HR hr = hrService.getHRById(id);
        model.addAttribute("hr", hr); // Pass the HR object to the view
        return "editHR"; // Ensure this matches your HTML file name without the extension
    }
}
