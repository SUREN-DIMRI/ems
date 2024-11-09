package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;
import com.EmployeeManagementSystem.EMS.Service.admin_service.TLService;

@Controller
public class TLController {

    @Autowired
    private TLService tlService;

    // Display Team Leaders with pagination and optional search query
    @GetMapping("/admin/tl")
    public String getTL(
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "query", required = false) String query,
        Model model) {
        
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<TL> tlPage;

        if (query != null && !query.trim().isEmpty()) {
            tlPage = tlService.searchTL(query, pageable);
            model.addAttribute("query", query);
        } else {
            tlPage = tlService.getPaginatedTL(pageable);
        }
        
        model.addAttribute("tlList", tlPage.getContent());
        model.addAttribute("pageNumber", page);
        model.addAttribute("totalPages", tlPage.getTotalPages());

        return "tl";
    }

    // Separate search mapping for the Search button
    @GetMapping("/searchTL")
    public String searchTL(
        @RequestParam("query") String query,
        @RequestParam(value = "page", defaultValue = "1") int page,
        Model model) {
        
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<TL> tlPage = tlService.searchTL(query, pageable);

        model.addAttribute("tlList", tlPage.getContent());
        model.addAttribute("query", query);
        model.addAttribute("pageNumber", page);
        model.addAttribute("totalPages", tlPage.getTotalPages());

        return "tl"; 
    }

    // Add a new Team Leader
    @PostMapping("/addTL")
    public String addTL(
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email,
        Model model) {
        
        if (name != null && !name.trim().isEmpty() &&
            department != null && !department.trim().isEmpty() && 
            email != null && !email.trim().isEmpty()) {

            TL newTL = new TL();
            newTL.setName(name);
            newTL.setDepartment(department);
            newTL.setEmail(email);
            tlService.addTL(newTL);
            model.addAttribute("success", "Team Leader added successfully.");
        } else {
            model.addAttribute("error", "All fields are required.");
            return "tl"; 
        }

        return "redirect:/admin/tl";
    }

    // Delete a Team Leader
    @PostMapping("/tl/delete/{id}")
    public String deleteTL(@PathVariable("id") Long id, Model model) {
        tlService.deleteTL(id);
        model.addAttribute("success", "Team Leader deleted successfully.");
        return "redirect:/admin/tl";
    }

    // Show the edit form for a Team Leader
    @GetMapping("/tl/edit/{id}")
    public String showEditTLForm(@PathVariable("id") Long id, Model model) {
        TL tl = tlService.getTLById(id);
        if (tl != null) {
            model.addAttribute("tl", tl);
            return "editTL";
        } else {
            model.addAttribute("error", "Team Leader not found.");
            return "redirect:/admin/tl";
        }
    }

    // Update the Team Leader details
    @PostMapping("/tl/update/{id}")
    public String updateTL(
        @PathVariable("id") Long id,
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email,
        Model model) {
        
        if (name != null && !name.trim().isEmpty() &&
            department != null && !department.trim().isEmpty() &&
            email != null && !email.trim().isEmpty()) {

            TL tl = new TL();
            tl.setId(id);
            tl.setName(name);
            tl.setDepartment(department);
            tl.setEmail(email);
            tlService.updateTL(tl);
            model.addAttribute("success", "Team Leader updated successfully.");
        } else {
            return "redirect:/tl/edit/" + id + "?error=All fields are required.";
        }

        return "redirect:/admin/tl";
    }
}
