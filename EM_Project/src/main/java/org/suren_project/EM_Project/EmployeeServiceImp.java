package org.suren_project.EM_Project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.suren_project.EmployeeEntity;
import org.suren_project.EmployeeRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        //employees.add(employee);
        return "saved successfully";
    }
 
    @Override
    public List<Employee> readEmployees() {
       return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        employees.remove(id);
        return true;
    }
    
}
