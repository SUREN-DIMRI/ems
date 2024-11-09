package com.EmployeeManagementSystem.EMS.Repository.admin_repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository provides built-in methods for CRUD operations
    @SuppressWarnings("null")
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByNameContainingOrDepartmentContainingOrPositionContaining(String name, String department, String position, Pageable pageable);
    
    
}