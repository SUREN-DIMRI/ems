package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/admin/tl")
    public String getTL(Model model) {
        List<TL> tlList = tlService.getAllTL();
        model.addAttribute("tlList", tlList);
        return "tl"; // This will map to tl.html
    }

    @PostMapping("/addTL")
    public String addTL(
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email,
        Model model
    ) {
        TL newTL = new TL();
        newTL.setName(name);
        newTL.setDepartment(department);
        newTL.setEmail(email);
        tlService.addTL(newTL);

        List<TL> tlList = tlService.getAllTL();
        model.addAttribute("tlList", tlList);

        return "tl"; // This will display the updated TL list on the same page
    }

    @PostMapping("/tl/delete/{id}")
    public String deleteTL(@PathVariable("id") Long id) {
        tlService.deleteTL(id);
        return "redirect:/admin/tl"; // Redirects back to the TL list page after deletion
    }

    // Method to show the edit form
    @GetMapping("/tl/edit/{id}")
    public String showEditTLForm(@PathVariable("id") Long id, Model model) {
        TL tl = tlService.getTLById(id); // You need to implement this method in TLService
        model.addAttribute("tl", tl);
        return "editTL"; // This will map to editTL.html
    }

    // Method to update the Team Leader details
    @PostMapping("/tl/update/{id}")
    public String updateTL(
        @PathVariable("id") Long id,
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email
    ) {
        TL tl = new TL();
        tl.setId(id);
        tl.setName(name);
        tl.setDepartment(department);
        tl.setEmail(email);
        tlService.updateTL(tl); // You need to implement this method in TLService
        return "redirect:/admin/tl"; // Redirects back to the TL list page after update
    }

    
}
