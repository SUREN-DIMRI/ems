package com.EmployeeManagementSystem.EMS.Service.hr_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Repository.hr_repository.HRManagementRepository;

@Service
public class HRManagementService {
    
    @Autowired
    private HRManagementRepository hrManagementRepository;

    public boolean verifyHR(String username, String password) {
        // Call repository method to check for existence based on name and email
        return hrManagementRepository.existsByNameAndEmail(username, password);
    }

    public long getTotalDepartments() {
        // Assuming you have a method to get the total number of departments
        // Implement this based on your business logic
        return 0; // Replace with actual implementation
    }
}

