package com.EmployeeManagementSystem.EMS.Service.admin_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch all employees from the database
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Save a new or existing employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Fetch an employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        return employeeOpt.orElse(null); // Return the employee if found, otherwise return null
    }

    // Optionally, add a method to delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Get the total number of employees
    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    public Page<Employee> getPaginatedEmployees(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return employeeRepository.findAll(pageable);
    }

    public Page<Employee> searchEmployees(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findByNameContainingOrDepartmentContainingOrPositionContaining(query, query, query, pageable);
    }
}
