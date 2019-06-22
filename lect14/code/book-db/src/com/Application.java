package com;

import com.repo.JDBCBookRepository;

public class Application {
	
	public static void main(String[] args) {
		
		JDBCBookRepository bookRepo = new JDBCBookRepository();
		
		bookRepo.getInfo();
		
	}

}
