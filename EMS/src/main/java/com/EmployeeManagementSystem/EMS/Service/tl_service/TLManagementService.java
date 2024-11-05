package com.EmployeeManagementSystem.EMS.Service.tl_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.tl_entity.task;
import com.EmployeeManagementSystem.EMS.Repository.tl_repository.TLManagementRepository;

@Service
public class TLManagementService {
    
    @Autowired
    private TLManagementRepository tlManagementRepository;

    public boolean verifyTL(String username, String password) {
        // Ensure this logic matches your database structure
        return tlManagementRepository.existsByNameAndEmail(username, password);
    }

    public List<task> getTasksForTL(String employeeName) {
        return tlManagementRepository.findByName(employeeName); // Update this call to the new repository method
    }
}
