package com.repo;

import java.util.List;

import com.model.Chapter;

public interface BookRepository {
	
	public List<Chapter> getChapters(int bookISBN);
	public void getBooks(int publisherID);
	public void getInfo();

}
