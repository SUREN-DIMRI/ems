package com.EmployeeManagementSystem.EMS.Entity.admin_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each TL

    private String department; // Department of the TL
    private String email; // Email of the TL
    private String name; // Name of the TL
}
