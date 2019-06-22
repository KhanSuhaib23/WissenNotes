package com.model;

public class Chapter {
	
	private int index;
	private String title;
	private int pages;
	private int bookISBN;
	
	public Chapter(int index, String title, int pages, int bookISBN) {
		super();
		this.index = index;
		this.title = title;
		this.pages = pages;
		this.bookISBN = bookISBN;
	}

	public int getIndex() {
		return index;
	}

	public String getTitle() {
		return title;
	}

	public int getPages() {
		return pages;
	}

	public int getBookISBN() {
		return bookISBN;
	}

	@Override
	public String toString() {
		return "Chapter [index=" + index + ", title=" + title + ", pages=" + pages + ", bookISBN=" + bookISBN + "]";
	}
	
	
	
}
