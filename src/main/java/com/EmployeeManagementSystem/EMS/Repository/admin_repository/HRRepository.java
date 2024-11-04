package com.EmployeeManagementSystem.EMS.Repository.admin_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;

public interface HRRepository extends JpaRepository<HR,Long>{
    
}
