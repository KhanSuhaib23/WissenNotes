package com;

import java.util.Optional;

import com.model.Product;
import com.repo.JDBCProductRepository;

public class App {
	
	public static void main(String[] args) {
		
		JDBCProductRepository repo = new JDBCProductRepository();
		
		System.out.println(repo.getById(102));
		
		
		
	}

}
