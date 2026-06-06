package com.farmermarket;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Delhi", "IT", 50000, null),
                new Employee("Bob", "Mumbai", "HR", 60000, null),
                new Employee("Charlie", "Delhi", "IT", 70000, null),
                new Employee("David", "Mumbai", "Sales", 40000, null),
                new Employee("Eve", "Delhi", "HR", 80000, null),
                new Employee("Frank", "Bangalore", "IT", 90000, null),
                new Employee("Grace", "Delhi", "Sales", 30000, null)
        );

        //System.out.println("Total employees from Delhi: " +
           // EmployeeService.countEmployeesByCity(employees, "Delhi"));
        
        //System.out.println("Employees with salary > 60000: " +
            //EmployeeService.employeesWithSalaryGreaterThan(employees, 60000));

        System.out.println(EmployeeService.groupByDepartment(employees));
        // Call other methods similarly...
    }
}

