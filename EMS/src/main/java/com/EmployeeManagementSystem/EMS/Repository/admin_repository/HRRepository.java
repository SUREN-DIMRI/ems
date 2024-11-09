package com.EmployeeManagementSystem.EMS.Repository.admin_repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;

public interface HRRepository extends JpaRepository<HR,Long>{
    @SuppressWarnings("null")
    Page<HR> findAll(Pageable pageable);

    Page<HR> findByNameContainingOrDepartmentContaining(String name, String department, Pageable pageable);

}
