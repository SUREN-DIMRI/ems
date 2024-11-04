package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;
import com.EmployeeManagementSystem.EMS.Service.admin_service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees and display them
    @GetMapping("/admin/employee")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee"; // This will map to employee.html
    }

    // Add a new employee
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/admin/employee"; // Redirect to employee page to see the updated list
    }

    // Get the form to edit an employee by ID
    @GetMapping("employee/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id); // Fetch the employee using the service
        model.addAttribute("employee", employee);
        return "editEmp"; // This will map to editEmp.html
    }

    // Update the employee details
    @PostMapping("/updateEmp/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id); // Set the ID to ensure the correct employee is updated
        employeeService.saveEmployee(employee); // Save the updated employee
        return "redirect:/admin/employee"; // Redirect to employee page to see the updated list
    }

    @PostMapping("/admin/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id); // Call the service to delete the employee
        return "redirect:/admin/employee"; // Redirect to the employee list page after deletion
    }
}
