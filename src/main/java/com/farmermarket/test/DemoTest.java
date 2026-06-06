package com.farmermarket.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(new Employee("revan", "j"), new Employee("Rahul", "kumar"),
				new Employee("revan", "j"));

		List<Employee> uniqeList = empList.stream().distinct().collect(Collectors.toList());

		int input[] = { 1, 3, 4, 5, 9, 8, 11, 10 };
		
	}
}
