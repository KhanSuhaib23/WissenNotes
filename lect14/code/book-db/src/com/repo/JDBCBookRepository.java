package com.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.SQLConnectionFactory;
import com.model.BookInfo;
import com.model.Chapter;

public class JDBCBookRepository implements BookRepository {

	@Override
	public List<Chapter> getChapters(int bookISBN) {

		return null;

	}

	@Override
	public void getBooks(int publisherID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getInfo() {

		try {
			Connection connection = SQLConnectionFactory.getConnection();

			String sql = "select b.isbn ISBN, b.title Title, p.name Publisher, b.price Price, ch.tchaps Chapters, ch.tpages Pages from (publisher p	join book b on p.id = b.publisher_id) join (select c.book_isbn bisbn, count(c.chapter_index) tchaps, sum(c.pages) tpages from chapter c group by c.book_isbn) ch on ch.bisbn = b.isbn";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println(sql);
			
			while (rs.next()) {
				
				
				
				int isbn = rs.getInt(1);
				String bookTitle = rs.getString(2);
				String publisherName = rs.getString(3);
				double price = rs.getDouble(4);
				int totalChapters = rs.getInt(5);
				int totalPages = rs.getInt(6);
				
				BookInfo bookInfo = new BookInfo(isbn, bookTitle, publisherName, price, totalPages, totalChapters);
				
				System.out.println(bookInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		return result;

	}

}
