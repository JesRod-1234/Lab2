package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeManagerTest {

    @Test
    @DisplayName("Test1")
    void testEmployeeRepository(){
        EmployeeRepository employeeRepository = new TestEmployeeRepository();

        employeeRepository.findAll();
        var actual = employeeRepository.findAll();
        var employees   = actual.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId)->employeeId.getId())
                .collect(Collectors.toList());

        assertThat(employees).containsExactly(new Employee("Gustav", 25000).getId());
    }
}
