package com.cloudify.employeeportal.service;

import com.cloudify.employeeportal.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = List.of(
            new Employee("EMP001", "Karthikeya", "Cloud Engineering", "karthikeya@example.com", "Active"),
            new Employee("EMP002", "Ravi Kumar", "DevOps", "ravi@example.com", "Active"),
            new Employee("EMP003", "Anjali Sharma", "Security", "anjali@example.com", "Inactive"),
            new Employee("EMP004", "Priya Reddy", "Application Support", "priya@example.com", "Active"),
            new Employee("EMP005", "Arjun Rao", "Networking", "arjun@example.com", "Active")
    );

    public List<Employee> findAll() {
        return employees;
    }

    public long countActiveEmployees() {
        return employees.stream()
                .filter(employee -> "Active".equalsIgnoreCase(employee.status()))
                .count();
    }
}
