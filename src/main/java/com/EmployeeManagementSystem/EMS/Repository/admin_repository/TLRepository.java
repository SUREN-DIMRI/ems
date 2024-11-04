package com.EmployeeManagementSystem.EMS.Repository.admin_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;



public interface TLRepository extends JpaRepository<TL,Long> {
    TL findByEmail(String email);
}
