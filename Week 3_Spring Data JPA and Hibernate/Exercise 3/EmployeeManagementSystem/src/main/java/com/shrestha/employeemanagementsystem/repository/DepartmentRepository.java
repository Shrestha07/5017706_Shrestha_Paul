package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods can be defined here
    // Example: Find department by name
    Department findByName(String name);
}