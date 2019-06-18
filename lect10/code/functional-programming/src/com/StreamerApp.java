package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Pipeline<T> {

	private List<T> input;

	public Pipeline(List<T> input) {
		this.input = input;
	}

	public Pipeline<T> filter(Predicate<T> condition) {

		List<T> out = new ArrayList<T>();

		for (T elem : input) {
			if (condition.test(elem)) {
				out.add(elem);
			}
		}

		return new Pipeline<T>(out);

	}

	public <R> Pipeline<R> map(Function<T, R> project) {

		List<R> out = new ArrayList<R>();

		for (T elem : input) {
			out.add(project.apply(elem));
		}

		return new Pipeline<R>(out);

	}

	public void forEach(Consumer<T> disp) {

		for (T elem : input) {
			disp.accept(elem);
		}

	}

}

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

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}

public class StreamerApp {

	public static void main(String[] args) {

		List<Product> products = Arrays.asList(

				new Product(101, "item-1", 1000.0), new Product(107, "item-7", 7000.0),
				new Product(103, "item-3", 3000.0), new Product(102, "item-2", 2000.0),
				new Product(105, "item-5", 5000.0), new Product(106, "item-6", 6000.0),
				new Product(104, "item-4", 4000.0)

		);

		Pipeline<Product> pipeline = new Pipeline<>(products);

		pipeline.filter(p -> p.getPrice() > 5000).map(p -> p.getName()).forEach(System.out::println);

		System.out.println();

		pipeline.filter(p -> p.getPrice() > 5000).map(p -> p.getId()).forEach(System.out::println);

		System.out.println();

		pipeline.filter(p -> p.getPrice() < 5000).map(p -> p.getName()).forEach(System.out::println);

	}

}
