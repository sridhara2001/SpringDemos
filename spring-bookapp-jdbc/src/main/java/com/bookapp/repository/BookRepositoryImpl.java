package com.bookapp.repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.Queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements IBookRepository {
	private JdbcTemplate jdbcTemplate;

	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addBook(Book book) {
		Object[] bookArray = {book.getTitle(),book.getAuthor(),book.getCategory(),book.getBookId(),book.getPrice()};
		jdbcTemplate.update(Queries.INSERTQUERY,bookArray);
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		jdbcTemplate.update(Queries.UPDATEQUERY,price,bookId);
		
	}

	@Override
	public void deleteBook(int bookId) {
		jdbcTemplate.update(Queries.DELETEQUERY,bookId);
		
	}

	@Override
	public Book findById(int bookId) throws IdNotFoundException {
		Book book = jdbcTemplate.queryForObject(Queries.FINDBYID, new BookMapper(), bookId);
		return book;
	}

	@Override
	public List<Book> findAll() {
		RowMapper<Book> mapper = new BookMapper();
		List<Book> book = jdbcTemplate.query(Queries.FINDALLQUERY, mapper);
		return book;
	}

	@Override
	public List<Book> findByAuthorContains(String author) throws BookNotFoundException {
		return jdbcTemplate.query(Queries.FINDBYAUTHOR,(rs, rowNum)->{
			Book book = new Book();
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setCategory(rs.getString("category"));
			book.setBookId(rs.getInt("book_id"));
			book.setPrice(rs.getInt("price"));
			return book;
		}, author);
	}

	@Override
	public List<Book> findByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = jdbcTemplate.query(Queries.FINDBYLESSPRICE,new BookMapper(), price);
		return books;
	}

	@Override
	public List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = jdbcTemplate.query(Queries.FINDBYAUTHORANDCATEGORY,new BookMapper(), author, category);
		return books;
	}

   
}
