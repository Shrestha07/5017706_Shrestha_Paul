package com.shrestha.employeemanagementsystem.repository;

import com.shrestha.employeemanagementsystem.entity.Department;
import com.shrestha.employeemanagementsystem.projection.DepartmentProjection;
import com.shrestha.employeemanagementsystem.projection.DepartmentProjectionImpl;
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

    // Interface-based projection
    @Query("SELECT d.id AS id, d.name AS name FROM Department d WHERE d.name = :name")
    DepartmentProjection findByNameAsProjection(@Param("name") String name);

    // Class-based projection
    @Query("SELECT new com.shrestha.employeemanagementsystem.projection.DepartmentProjectionImpl(d.id, d.name) FROM Department d WHERE d.name = :name")
    DepartmentProjectionImpl findByNameAsProjectionImpl(@Param("name") String name);
}