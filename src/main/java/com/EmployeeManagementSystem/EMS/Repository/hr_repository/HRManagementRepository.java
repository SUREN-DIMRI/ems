package com.EmployeeManagementSystem.EMS.Repository.hr_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;

public interface HRManagementRepository extends JpaRepository<HR, Long> {
    // Change the method to use 'name' instead of 'username'
    boolean existsByNameAndEmail(String name, String email);
}
