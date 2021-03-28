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
    void testEmployeeRepository() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();

        employeeRepository.findAll();
        var actual = employeeRepository.findAll();
        var employees = actual.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());

        assertThat(employees).containsExactly(new Employee("Gustav", 25000).getId());
    }

    @Test
    @DisplayName("Test mocking")
    void testMocking() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));

        employeeRepository.findAll();
        var actual = employeeRepository.findAll();
        var employees = actual.stream()
                .filter(employee -> employee.getId().equals("Gustav"))
                .map((employeeId) -> employeeId.getId())
                .collect(Collectors.toList());

        assertThat(employees).containsExactly(new Employee("Gustav", 25000).getId());

    }

    @Test
    @DisplayName("Test mocking for Paid")
    void testMockingPaid() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 28000),
                new Employee("Tahar", 29000)));

        var actual = employeeRepository.findAll();
        actual.get(0).setPaid(true);

        assertEquals(true, (actual.get(0).isPaid()));

    }

    @Test
    @DisplayName("Test setId")
    void testsetId() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));

        employeeRepository.findAll().get(0).setId("Gunnar");


        assertTrue(employeeRepository.findAll().get(0).getId().equals("Gunnar"));

    }

    @Test
    @DisplayName("Test setSalary")
    void testsetSalary() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000)));

        employeeRepository.findAll().get(0).setSalary(58900.0);


        assertTrue(employeeRepository.findAll().get(0).getSalary() == 58900.0);

    }

    @Test
    @DisplayName("test toString ")
    void testtoString() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000.0),
                new Employee("Jessica", 25000.0),
                new Employee("Tahar", 25000.0)));

        employeeRepository.findAll().get(0).toString();


        assertTrue(employeeRepository.findAll().get(0).toString().equals("Employee [id=" + "Gustav" + ", salary=" + 25000.0 + "]"));


    }

    @Test
    @DisplayName("Test employee pay employees ")
    void testPayEmployeeManager() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("Gustav", 25000.0),
                new Employee("Jessica", 25000.0),
                new Employee("Tahar", 25000.0)));

        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService );
        int expected = employeeManager.payEmployees();

        assertEquals(expected, 2);


    }
}
