package com.EmployeeManagementSystem.EMS.Repository.tl_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL; // Assuming TL is your team leader entity
import com.EmployeeManagementSystem.EMS.Entity.tl_entity.task;

public interface TLManagementRepository extends JpaRepository<TL, Long> {
    boolean existsByNameAndEmail(String name, String email);

    // Change to find tasks by the Employee entity
    List<task> findByName(String employeeName); // Assuming you want to find by employee's name
}
