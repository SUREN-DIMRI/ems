package com.EmployeeManagementSystem.EMS.Service.admin_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.TLRepository;

@Service
public class TLService {
    @Autowired
    private TLRepository tlRepository;

    // Get all TLs
    public List<TL> getAllTL() {
        return tlRepository.findAll();
    }

    // Add a new TL
    public void addTL(TL tl) {
        tlRepository.save(tl);
    }

    // Delete a TL by ID
    public void deleteTL(Long id) {
        tlRepository.deleteById(id);
    }

    // Get a TL by ID
    public TL getTLById(Long id) {
        Optional<TL> tl = tlRepository.findById(id);
        return tl.orElse(null); // Return null or throw an exception if TL not found
    }

    // Update a TL
    public void updateTL(TL tl) {
        tlRepository.save(tl); // This will handle both insert and update based on the presence of ID
    }
}
