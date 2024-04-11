//package com.example.adwise;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//public class DataInitializer {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostConstruct
//    public void init() {
//        jdbcTemplate.execute("INSERT INTO Profile (email, password, first_name, last_name, phone, role) VALUES ('jan.kowalski@example.com', 'password123', 'Jan', 'Kowalski', '123456789', 1), ('anna.nowak@example.com', 'pass123', 'Anna', 'Nowak', '987654321', 2), ('adam.malysz@example.com', 'test123', 'Adam', 'Małysz', '555555555', 1)");
//    }
//}
