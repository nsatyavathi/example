package com.sym.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name;
	private int salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}

class EmployeeSubset {
	private String name;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeSubset(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public EmployeeSubset() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeSubset [name=" + name + ", salary=" + salary + "]";
	}

}

public class Java8Example {

	public static List<Employee> createEmployeeList() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(100, "Satya", 20000));
		empList.add(new Employee(101, "Tani", 50000));
		empList.add(new Employee(102, "Shri", 50000));
		empList.add(new Employee(103, "Rami", 45000));
		// empList.forEach(System.out::println);
		return empList;
	}

	public static void main(String[] args) {
		List<Employee> list = createEmployeeList();
		
		// filter all the employee whose salary is greater than 25000 and print the
		// employee names.
		/* List<Employee> filterList = list.stream().filter(e -> e.getSalary() > 25000)
				// .map(Employee::getName)
				.map(e -> {
					e.setSalary(e.getSalary() + 10000);
					return e;
				}).collect(Collectors.toList());
		filterList.forEach(System.out::println); */
		
		//list contain only name and salary using java8
		
		List<EmployeeSubset> li = list.stream()
				.map(temp ->
				{
					EmployeeSubset obj = new EmployeeSubset();
					obj.setName(temp.getName());
					obj.setSalary(temp.getSalary());
					return obj;
				})
				.collect(Collectors.toList());
		//li.forEach(System.out::println);
		
		//list.stream().map(e-> e.getSalary()+1000).forEach(System.out::println);
		
		Comparator<Employee> sortByName = Comparator.comparing(Employee::getName);
		Collections.sort(list, sortByName);
		list.forEach(System.out::println);
	}

}
