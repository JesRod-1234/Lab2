package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeManagerIT {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    BankService bankService = new TestBankService();
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);



    @BeforeEach
    void setUp() {

        employeeRepository.employees.add(new Employee("Jessica",35.000 ));
        employeeRepository.employees.add(new Employee("Robin",79.000 ));
        employeeRepository.employees.add(new Employee("Alexander",24.000 ));
        employeeRepository.employees.add(new Employee("Nicole",22.000 ));

    }

    @Test
    @DisplayName("Test employee pay employees inMemoryVersion")
    void testInMemoryVersion() {


        int expected = employeeManager.payEmployees();

        assertEquals(expected, 4);


    }
    @Test
    @DisplayName("Test save method")
    void testSaveMethod() {

        employeeRepository.save(new Employee("Arturo", 45999.0));

        int expected = employeeManager.payEmployees();

        assertEquals(expected, 5);


    }


}