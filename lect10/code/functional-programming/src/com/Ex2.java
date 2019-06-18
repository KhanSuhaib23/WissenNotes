package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@FunctionalInterface
interface EmployeeInput {
	
	public void put(int id, String name, double salary);
	
}

class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
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

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}

public class Ex2 {
	
	
	
	public static void writeToFile(String log) {
		File file = new File("log.txt");
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file, true);
			writer.write(log);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		BiFunction<String, Employee, String> getMessage = (msg, emp) ->   {
			return msg + ": \n" + emp;
		};
		
		BiConsumer<String, Employee> logger = (msg, emp) -> System.out.println(getMessage.apply(msg, emp));
		
		
		
		
		EmployeeInput addEmployee = (id, name, salary) -> {
			
		};
		
	}
	
}
