package com.wissen.hr;

import com.wissen.emp.Employee;

public class HR {

	public static void manage()
	{
		Employee.trainerName = "TRN";
		
		Employee e1 = new Employee();
		
		e1.id = 101;
		e1.name = "ABC";
		
		Employee e2 = new Employee();
		
		e2.id = 102;
		e2.name = "PQR";
		
		e1.printInfo();
		e2.printInfo();
		
		
	}
	
}
