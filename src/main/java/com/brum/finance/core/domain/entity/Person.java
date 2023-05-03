package com.brum.finance.core.domain.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String email;
    private Double salary;
    private LocalDate salaryDueDate;
    private String password;
    private Timestamp createdAt;
}
