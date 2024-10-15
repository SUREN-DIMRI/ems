package org.suren_project.EM_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.suren_project.EM_Project.DTO.EmployeeEntity;
import org.suren_project.EM_Project.Repository.EmployeeRepository;

@SpringBootApplication
public class EmProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmProjectApplication.class, args);
	}
}
