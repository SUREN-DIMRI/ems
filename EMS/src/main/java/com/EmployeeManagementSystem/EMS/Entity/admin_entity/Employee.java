package com.EmployeeManagementSystem.EMS.Entity.admin_entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private Long id;

    private String name;
    private String position;
    private String department;
    private String email;
    //private String salary;

}
