package com.farmermarket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Java8InterviewProgramsQ {

    // 1. Second highest salary
    public static Optional<Employee> secondHighestSalaryWithEmployeeObject(List<Employee> employees) {
        return employees.stream()
                //.map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
    }
    
 // 1. Second highest salary
    public static Optional<Double> secondHighestSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 25, 50000, "IT", null),
                new Employee(2, "Bob", 35, 70000, "HR", null),
                new Employee(3, "Charlie", 40, 80000, "IT", null),
                new Employee(4, "David", 28, 55000, "Finance", null),
                new Employee(5, "Eve", 35, 70000, "IT", null),
                new Employee(6, "Alice", 30, 60000, "Finance", null)
        );

        System.out.println("Second Highest Salary: " + secondHighestSalary(employees));
    }
}

