package com.EmployeeManagementSystem.EMS.Repository.hr_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagementSystem.EMS.Entity.hr_entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
    
}
