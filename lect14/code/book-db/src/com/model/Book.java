package com.model;

public class Book {
	
	private int isbn;
	private String title;
	private double price;
	private int publisherId;
	
	
	public Book(int isbn, String title, double price, int publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publisherId = publisherId;
	}


	public int getIsbn() {
		return isbn;
	}


	public String getTitle() {
		return title;
	}


	public double getPrice() {
		return price;
	}


	public int getPublisherId() {
		return publisherId;
	}


	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisherId=" + publisherId + "]";
	}
	
	

}
