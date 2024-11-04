package com.EmployeeManagementSystem.EMS.Repository.employee_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {
    boolean existsByNameAndEmail(String name, String email);
}
