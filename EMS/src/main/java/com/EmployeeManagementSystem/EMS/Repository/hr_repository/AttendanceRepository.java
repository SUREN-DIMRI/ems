package com.EmployeeManagementSystem.EMS.Repository.hr_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagementSystem.EMS.Entity.hr_entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Long>{

    boolean existsByEmployeeIdAndDate(Long employeeId, String date);
    
}
