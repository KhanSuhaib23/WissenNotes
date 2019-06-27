package com.wissen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "employee")
public class Employee {
	
//	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String name;
	
	@Enumerated (EnumType.STRING)
	private EmployeeType employeeType;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable (name = "phone_number", joinColumns = { @JoinColumn( name = "e_id") })
	private List<String> numbers;
	
	@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Department department;
	public Employee() {
		
	}
	
	public Employee(int id, String name, EmployeeType employeeType, Address address, List<String> numbers,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.employeeType = employeeType;
		this.address = address;
		this.numbers = numbers;
		this.department = department;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employeeType=" + employeeType + ", address=" + address
				+ ", numbers=" + numbers + ", department=" + department + "]";
	}


	
	

}
