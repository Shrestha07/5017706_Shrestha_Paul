package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query method to find employees by name with pagination and sorting
    Page<Employee> findByName(String name, Pageable pageable);

    // Custom query method to find employee by email
    Employee findByEmail(String email);

    // Custom query to find employees by department's name with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    Page<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    // Custom query to find employees by email containing a specific substring with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:emailSubstring%")
    Page<Employee> findEmployeesByEmailContaining(@Param("emailSubstring") String emailSubstring, Pageable pageable);
}