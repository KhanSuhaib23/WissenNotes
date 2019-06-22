package com.model;

public class BookInfo {
	
	private int isbn;
	private String bookTitle;
	private String publisherName;
	private double price;
	private int totalPages;
	private int totalChapters;
	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", bookTitle=" + bookTitle + ", publisherName=" + publisherName + ", price="
				+ price + ", totalPages=" + totalPages + ", totalChapters=" + totalChapters + "]";
	}
	public BookInfo(int isbn, String bookTitle, String publisherName, double price, int totalPages, int totalChapters) {
		super();
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.publisherName = publisherName;
		this.price = price;
		this.totalPages = totalPages;
		this.totalChapters = totalChapters;
	}

}
