package com.EmployeeManagementSystem.EMS.Repository.admin_repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;
import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;



public interface TLRepository extends JpaRepository<TL,Long> {
    TL findByEmail(String email);

    @SuppressWarnings("null")
    Page<TL> findAll(Pageable pageable);


    Page<TL> findByNameContainingOrDepartmentContainingOrEmailContaining(String name, String department, String email, Pageable pageable);

    List<Employee> findByDepartment(String department);
}

