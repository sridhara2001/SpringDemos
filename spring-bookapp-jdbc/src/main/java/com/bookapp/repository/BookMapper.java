package com.bookapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookapp.model.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setCategory(rs.getString("category"));
		book.setBookId(rs.getInt("book_id"));
		book.setPrice(rs.getInt("price"));
		return book;
	}
	

}
