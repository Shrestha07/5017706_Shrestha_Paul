package com.shrestha.employeemanagementsystem.service;

import com.shrestha.employeemanagementsystem.entity.Department;
import com.shrestha.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null); // Return null if not found
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department findDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
}