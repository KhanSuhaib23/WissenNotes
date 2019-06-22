package com.repo;

import java.util.List;

import com.model.Product;

public interface ProductRepository {

	public void save(Product product);
	public List<Product> getAll();
	
}
