package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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

    @Test
    @DisplayName("Test mocking")
    void testMocking(){

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee( "Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));

        employeeRepository.findAll();
        var actual = employeeRepository.findAll();
        var employees   = actual.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId)->employeeId.getId())
                .collect(Collectors.toList());

        assertThat(employees).containsExactly(new Employee("Gustav", 25000).getId());

    }
}
