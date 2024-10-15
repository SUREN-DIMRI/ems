package org.suren_project.EM_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suren_project.EM_Project.DTO.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{
    
}
