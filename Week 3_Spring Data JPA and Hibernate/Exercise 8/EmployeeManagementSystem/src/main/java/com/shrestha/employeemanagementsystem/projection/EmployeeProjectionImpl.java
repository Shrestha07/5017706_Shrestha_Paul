package com.shrestha.employeemanagementsystem.projection;

public class EmployeeProjectionImpl {
    private Long id;
    private String name;
    private String email;

    public EmployeeProjectionImpl(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}