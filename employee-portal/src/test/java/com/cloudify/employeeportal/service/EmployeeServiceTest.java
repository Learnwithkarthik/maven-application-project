package com.cloudify.employeeportal.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void shouldReturnFiveEmployees() {
        assertThat(employeeService.findAll()).hasSize(5);
    }

    @Test
    void shouldCountFourActiveEmployees() {
        assertThat(employeeService.countActiveEmployees()).isEqualTo(4);
    }
}
