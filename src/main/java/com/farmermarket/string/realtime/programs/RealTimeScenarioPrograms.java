package com.farmermarket.string.realtime.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RealTimeScenarioPrograms {

	// Group Employees by Department
	public static Map<String, List<Employee>> findEmployeesDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}	

	// Count Number of Employees in Each Department
	public static Map<String, Long> findCountEmployeesEachDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

	}

	//Get the Highest Paid Employee from Each Department
	public static Map<String, Optional<Employee>> findHighestPaidEmployeesEachDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
	}

	public static void main(String[] args) {

		List<Department> departments = Arrays.asList(new Department(1, "HR", "Mumbai"),
				new Department(2, "Finance", "Delhi"), new Department(3, "IT", "Bangalore"),
				new Department(4, "Marketing", "Hyderabad"));

		List<Employee> employees = Arrays.asList(new Employee(101, "Alice", "HR", 60000, 32, true),
				new Employee(102, "Bob", "Finance", 75000, 45, true),
				new Employee(103, "Charlie", "IT", 90000, 28, true), new Employee(104, "David", "IT", 87000, 35, false),
				new Employee(105, "Eve", "Finance", 68000, 25, true), new Employee(106, "Frank", "HR", 58000, 38, true),
				new Employee(107, "Grace", "Marketing", 72000, 30, false),
				new Employee(108, "Heidi", "Marketing", 65000, 27, true),
				new Employee(109, "Ivan", "Finance", 80000, 50, true),
				new Employee(110, "Judy", "IT", 95000, 29, true));
		
		System.out.println(RealTimeScenarioPrograms.findEmployeesDepartment(employees));
		System.out.println(RealTimeScenarioPrograms.findCountEmployeesEachDepartment(employees));
		System.out.println(RealTimeScenarioPrograms.findHighestPaidEmployeesEachDepartment(employees));


	}
}
