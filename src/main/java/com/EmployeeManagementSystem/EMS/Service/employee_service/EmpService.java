package com.EmployeeManagementSystem.EMS.Service.employee_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Repository.employee_repository.EmpRepository;

@Service
public class EmpService {
    
    @Autowired
    private EmpRepository empRepository;

    public boolean verifyEmployee(String name , String email){
        return empRepository.existsByNameAndEmail(name, email);
    }

}
