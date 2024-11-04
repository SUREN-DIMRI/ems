package com.EmployeeManagementSystem.EMS.Repository.admin_repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.user;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {
    Optional<user> findByUsername(String username);
}