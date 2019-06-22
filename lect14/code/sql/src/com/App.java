package com;

import com.repo.JDBCProductRepository;

public class App {
	
	public static void main(String[] args) {
		
		JDBCProductRepository repo = new JDBCProductRepository();
		
		System.out.println(repo.getById(102));
		
		
		
	}

}
