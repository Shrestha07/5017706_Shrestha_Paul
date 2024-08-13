package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query method to find employees by name
    List<Employee> findByName(String name);

    // Custom query method to find employee by email
    Employee findByEmail(String email);

    // Custom query to find employees by department's name
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // Custom query to find employees by email containing a specific substring
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:emailSubstring%")
    List<Employee> findEmployeesByEmailContaining(@Param("emailSubstring") String emailSubstring);
}