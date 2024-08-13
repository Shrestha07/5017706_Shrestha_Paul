package com.shrestha.employeemanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class SecondaryDataSourceConfig {

    @Bean
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:secondarydb")
                .username("sa")
                .password("password")
                .driverClassName("org.h2.Driver")
                .build();
    }
}