package com.app.repo;

import java.util.List;

import com.app.model.Product;

public interface ProductRepository {

	public void save(Product product);
	public List<Product> getAll();
	
}
