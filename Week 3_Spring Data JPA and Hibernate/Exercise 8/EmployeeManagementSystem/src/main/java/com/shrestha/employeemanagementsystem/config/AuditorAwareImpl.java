package com.shrestha.employeemanagementsystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the current user's username
        // For demonstration purposes, return a hardcoded value
        return Optional.of("system"); // Replace with actual user retrieval logic
    }
}