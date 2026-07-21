package com.cloudify.employeeportal.model;

public record Employee(
        String employeeId,
        String name,
        String department,
        String email,
        String status) {
}
