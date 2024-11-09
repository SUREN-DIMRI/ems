package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;
import com.EmployeeManagementSystem.EMS.Service.admin_service.HRService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HRController {

    @Autowired
    private HRService hrService;

    // Get all HRs with pagination
    @GetMapping("/admin/hr")
    public String getHRs(
        Model model,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        Page<HR> hrPage = hrService.getPaginatedHRs(page, size);
        model.addAttribute("hrPage", hrPage);

        // Create a list of page numbers for pagination controls
        int totalPages = hrPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "hr"; // This will map to hr.html
    }

    // Add a new HR
    @PostMapping("/hr/add")
    public String addHR(@ModelAttribute HR hr) {
        hrService.addHR(hr);
        return "redirect:/admin/hr"; // Redirect to HR page to see the updated list
    }

    // Get the form to edit an HR by ID
    @GetMapping("hr/edit/{id}")
    public String editHRForm(@PathVariable Long id, Model model) {
        HR hr = hrService.getHRById(id); // Fetch the HR using the service
        model.addAttribute("hr", hr);
        return "editHR"; // This will map to editHR.html
    }

    // Update HR details
    @PostMapping("/updateHR/{id}")
    public String updateHR(@PathVariable Long id, @ModelAttribute HR hr) {
        hr.setId(id); // Set the ID to ensure the correct HR is updated
        hrService.updateHR(hr); // Save the updated HR
        return "redirect:/admin/hr"; // Redirect to HR page to see the updated list
    }

    // Delete an HR by ID
    @PostMapping("/admin/hr/delete/{id}")
    public String deleteHR(@PathVariable Long id) {
        hrService.deleteHR(id); // Call the service to delete the HR
        return "redirect:/admin/hr"; // Redirect to the HR list page after deletion
    }

    // Search HRs with pagination
    @GetMapping("/admin/hr/search")
    public String searchHRs(
        @RequestParam String query,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        Model model
    ) {
        Page<HR> hrPage = hrService.searchHRs(query, page, size);
        model.addAttribute("hrPage", hrPage);

        // Create a list of page numbers for pagination controls
        int totalPages = hrPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "hr"; // Return to the HR page
    }
}
