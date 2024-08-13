package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query method to find department by name
    Department findByName(String name);

    // Custom query to count departments by name
    @Query("SELECT COUNT(d) FROM Department d WHERE d.name = :name")
    long countDepartmentsByName(@Param("name") String name);
}