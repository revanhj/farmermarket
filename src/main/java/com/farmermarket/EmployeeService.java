package com.farmermarket;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

	public static long countEmployeesByCity(List<Employee> employees, String city) {
		return employees.stream().filter(e -> e.getCity().equalsIgnoreCase(city)).count();
	}

	public static Map<String, Long> countEmployeesByCityT(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
	}

	public static Map<Object, Long> countCharCity(String city) {
		return city.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
	
	public static List<Employee> employeesWithSalaryGreaterThan(List<Employee> employees, double amount) {
		return employees.stream().filter(e -> e.getSalary() > amount).collect(toList());
	}

	public static List<String> getEmployeeNamesUpperSorted(List<Employee> employees) {
		return employees.stream().map(e -> e.getName().toUpperCase()).sorted().collect(toList());
	}

	public static Employee getFirstEmployeeInHR(List<Employee> employees) {
		return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).findFirst()
				.orElseThrow(() -> new RuntimeException("No employee found in HR"));
	}

	public static Long getEmployeeInHRCount(List<Employee> employees) {
		return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).count();

	}

	public static double getTotalSalaryByDepartment(List<Employee> employees, String dept) {
		return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase(dept)).mapToDouble(Employee::getSalary)
				.sum();
	}

	public static boolean isAllSalaryAbove(List<Employee> employees, double value) {
		return employees.stream().allMatch(e -> e.getSalary() > value);
	}

	public static Map<String, Double> getSumAndAverageSalary(List<Employee> employees) {
		double sum = employees.stream().mapToDouble(Employee::getSalary).sum();
		double avg = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		Map<String, Double> result = new HashMap<>();
		result.put("sum", sum);
		result.put("avg", avg);
		return result;
	}

	public static Map<String, Double> mapEmployeeNameToSalary(List<Employee> employees) {
		return employees.stream().collect(toMap(Employee::getName, Employee::getSalary));
	}

	public static List<Employee> sortEmployeesBySalaryDesc(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(toList());
	}

	public static List<Employee> getHighestSalaryEmployees(List<Employee> employees) {
		double max = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
		return employees.stream().filter(e -> e.getSalary() == max).collect(toList());
	}

	public static List<Employee> getSecondHighestSalaryEmployees(List<Employee> employees) {
		List<Double> sorted = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
				.collect(toList());
		if (sorted.size() < 2)
			return Collections.emptyList();
		double second = sorted.get(1);
		return employees.stream().filter(e -> e.getSalary() == second).collect(toList());
	}

	public static List<Employee> employeesAboveAverageSalary(List<Employee> employees) {
		double avg = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
		return employees.stream().filter(e -> e.getSalary() > avg).collect(toList());
	}

	public static Optional<Employee> getEmployeeWithLongestName(List<Employee> employees) {
		return employees.stream().max(Comparator.comparingInt(e -> e.getName().length()));
	}

	public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
		return employees.stream().collect(groupingBy(Employee::getDepartment));
	}

	public static Map<String, Long> countByDepartment(List<Employee> employees) {
		return employees.stream().collect(groupingBy(Employee::getDepartment, counting()));
	}

	public static Map<String, Double> sumSalaryByDepartment(List<Employee> employees) {
		return employees.stream().collect(groupingBy(Employee::getDepartment, summingDouble(Employee::getSalary)));
	}

	public static Map<String, Double> avgSalaryByDepartment(List<Employee> employees) {
		return employees.stream().collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));
	}

	public static boolean areAllEmployeesFromDepartment(List<Employee> employees, String dept) {
		return employees.stream().allMatch(e -> e.getDepartment().equalsIgnoreCase(dept));
	}

	public static Map<String, List<Employee>> groupByCityAndDepartment(List<Employee> employees, String dept) {
		return employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase(dept))
				.collect(groupingBy(Employee::getCity));
	}

	public static Optional<Map.Entry<String, Double>> departmentWithHighestAvgSalary(List<Employee> employees) {
		return employees.stream().collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)))
				.entrySet().stream().max(Map.Entry.comparingByValue());
	}
}
