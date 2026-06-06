package com.farmermarket;

public class Employee {
	private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
   private String city;
    public Employee(int id, String name, int age, double salary, String department, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.city = city;
    }

    public Employee(String string, String string2, String string3, int i, String city) {

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}
	
	public double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

    @Override
    public String toString() {
        return name + "(" + department + ", " + salary + ")";
    }
}
