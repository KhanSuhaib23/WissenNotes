package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Product {
	private int id;
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
}

public class App {
	
	public static void main(String[] args) {
		
		
		List<Product> products = Arrays.asList(
				
				new Product(123, "item-1", 1000.0),
				new Product(106, "item-7", 7000.0),
				new Product(978, "item-3", 3000.0),
				new Product(233, "item-2", 2000.0),
				new Product(654, "item-5", 5000.0),
				new Product(842, "item-6", 6000.0),
				new Product(782, "item-4", 4000.0)

			);
				
		
		for (Product prod : products) {
			if (prod.getPrice() > 4000.0)
				System.out.println(prod);
		}
		
		System.out.println("-------------------------------------------------");
		
		products.stream().filter(p -> p.getPrice() > 4000.0).forEach(System.out::println);
		
		Stream<Product> s = products.stream();
		
	}
}
