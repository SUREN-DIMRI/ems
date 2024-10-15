package org.suren_project.EM_Project.Service;

import org.suren_project.EM_Project.Entity.Employee;

import java.util.List;


public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
}
