package com.EmployeeManagementSystem.EMS.Service.hr_service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.hr_entity.Attendance;
import com.EmployeeManagementSystem.EMS.Entity.hr_entity.Salary;
import com.EmployeeManagementSystem.EMS.Repository.hr_repository.AttendanceRepository;
import com.EmployeeManagementSystem.EMS.Repository.hr_repository.HRManagementRepository;
import com.EmployeeManagementSystem.EMS.Repository.hr_repository.SalaryRepository;

@Service
public class HRManagementService {
    
    @Autowired
    private HRManagementRepository hrManagementRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;

    public boolean verifyHR(String username, String password) {
        // Call repository method to check for existence based on name and email
        return hrManagementRepository.existsByNameAndEmail(username, password);
    }

    // Method to set salary for an employee
    public void setSalary(Long employeeId, Double amount) {
        Salary salary = new Salary();
        salary.setEmployeeId(employeeId);
        salary.setAmount(amount);
        salaryRepository.save(salary); // Save the salary record to DB
    }

    // Method to mark attendance for an employee
    public boolean markAttendance(Long employeeId, Boolean isPresent) {
        // Get the current date
        String currentDate = LocalDate.now().toString();
    
        // Check if attendance already exists for the employee on this date
        boolean exists = attendanceRepository.existsByEmployeeIdAndDate(employeeId, currentDate);
    
        if (!exists) {
            // If no record exists, create a new attendance record
            Attendance attendance = new Attendance();
            attendance.setEmployeeId(employeeId);
            attendance.setIsPresent(isPresent);
            attendance.setDate(currentDate); // Set the current date
            attendanceRepository.save(attendance); // Save the attendance record to DB
            return true; // Successfully marked attendance
        }
        return false; // Attendance already marked for today
    }

    public long getTotalDepartments() {
        // Assuming you have a method to get the total number of departments
        // Implement this based on your business logic
        return 0; // Replace with actual implementation
    }
}

