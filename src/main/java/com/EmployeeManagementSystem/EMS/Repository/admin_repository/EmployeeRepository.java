package com.EmployeeManagementSystem.EMS.Repository.admin_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository provides built-in methods for CRUD operations
}