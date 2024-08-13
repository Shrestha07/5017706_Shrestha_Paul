package com.shrestha.employeemanagementsystem.service;

import com.shrestha.employeemanagementsystem.entity.Employee;
import com.shrestha.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> findEmployeesByName(String name, Pageable pageable) {
        return employeeRepository.findByName(name, pageable);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Page<Employee> findEmployeesByDepartmentName(String departmentName, Pageable pageable) {
        return employeeRepository.findEmployeesByDepartmentName(departmentName, pageable);
    }

    public Page<Employee> findEmployeesByEmailContaining(String emailSubstring, Pageable pageable) {
        return employeeRepository.findEmployeesByEmailContaining(emailSubstring, pageable);
    }

    // Optional: Example method for batch processing (if needed)
    public void batchSaveEmployees(Iterable<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}