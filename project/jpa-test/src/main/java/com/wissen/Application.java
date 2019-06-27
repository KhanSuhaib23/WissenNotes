package com.wissen;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.wissen.model.Address;
import com.wissen.model.Department;
import com.wissen.model.Employee;
import com.wissen.model.EmployeeType;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puint");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		
		Department d1 = new Department(11, "IT");
		Department d2 = new Department(12, "HR");
		
		
		
		List<String> numbers1 = Arrays.asList("1234", "5678");
		List<String> numbers2 = Arrays.asList("3423", "1343");
		List<String> numbers3 = Arrays.asList("6743", "7645");
		List<String> numbers4 = Arrays.asList("2314", "2321");
		List<String> numbers5 = Arrays.asList("3767", "8963");
		Employee e1 = new Employee(101, "Suhaib", EmployeeType.EMPLOYEE, new Address("Street 1", "Mumbai", "India"), numbers1, d1);
		Employee e2 = new Employee(102, "Asif", EmployeeType.CONTRACTOR, new Address("Street 1", "Mumbai", "India"), numbers2, d2);
		Employee e3 = new Employee(103, "Omkar", EmployeeType.EMPLOYEE, new Address("Street 2", "Mumbai", "India"), numbers3, d1);
		Employee e4 = new Employee(104, "Karan", EmployeeType.EMPLOYEE, new Address("Street 3", "Mumbai", "India"), numbers4, d2);
		Employee e5 = new Employee(105, "Shaaz", EmployeeType.CONTRACTOR, new Address("Street 4", "Thane", "India"), numbers5, d1);
		
		
		txn.begin();
		
		em.persist(d1);
		em.persist(d2);
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		
		
		Query q = em.createQuery("from Employee e where e.department.name='HR'");
		
		List<Employee> emp = q.getResultList();
		
		emp.forEach(System.out::println);
		
		txn.commit();
		
		em.close();
		
	}
	
}
