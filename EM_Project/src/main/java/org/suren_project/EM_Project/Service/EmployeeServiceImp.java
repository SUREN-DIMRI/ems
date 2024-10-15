package org.suren_project.EM_Project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren_project.EM_Project.DTO.EmployeeEntity;
import org.suren_project.EM_Project.Entity.Employee;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.suren_project.EM_Project.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    List<EmployeeEntity> employees = new ArrayList<>();

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
        employees = employeeRepository.findAll();
        List<Employee> ls = new ArrayList<>();
        for(EmployeeEntity en:employees){
            Employee employee = new Employee();
            employee.setId(en.getId());
            employee.setName(en.getName());
            employee.setPhone(en.getPhone());

            ls.add(employee);
        }
        return ls;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        employees.remove(id);
        return true;
    }
    
}
