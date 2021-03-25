package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {

    @Override

    public List<Employee> findAll(){

        return List.of(new Employee( "Gustav", 25000),
                new Employee("Jessica", 25000),
                new Employee("Tahar", 25000));



    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
