package com.EmployeeManagementSystem.EMS.Service.admin_service;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.user;
//import com.EmployeeManagementSystem.EMS.Repository.*;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        Optional<user> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getPassword().equals(password);
        }
        return false;
    }
}
