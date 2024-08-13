package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods can be defined here
    // Example: Find employees by name
    List<Employee> findByName(String name);

    // Example: Find employees by email
    Employee findByEmail(String email);
}