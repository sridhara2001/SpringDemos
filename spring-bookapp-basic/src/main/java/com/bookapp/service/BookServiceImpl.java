package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	private BookDetails details;
	
	@Autowired
    public void setDetails(BookDetails details) {
		this.details = details;
	}

	@Override
    public List<Book> getAll() {
        List<Book> books = details.showBooks();
        return books;
    }

    @Override
    public List<Book> getByAuthorStartsWith(String author) throws BookNotFoundException {
        List<Book> books = details.showBooks();
        List<Book> booksByAuthor = new ArrayList<>();
        for(Book book : books){
            if (book.getAuthor().startsWith(author)){
                booksByAuthor.add(book);
            }
        }
        if (booksByAuthor.isEmpty()){
            throw new BookNotFoundException("Book by this author not found");
        }
        return booksByAuthor;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books = details.showBooks();
        List<Book> booksByCategory = new ArrayList<>();
        for(Book book : books){
            if (book.getCategory().startsWith(category)){
                booksByCategory.add(book);
            }
        }
        if (booksByCategory.isEmpty()){
            throw new BookNotFoundException("Book by this category not found");
        }
        return booksByCategory;
    }

    @Override
    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
        List<Book> books = details.showBooks();
        List<Book> booksByPrice = new ArrayList<>();
        for(Book book : books){
            if (book.getPrice()<price){
                booksByPrice.add(book);
            }
        }
        if (booksByPrice.isEmpty()){
            throw new BookNotFoundException("Book not found less than this price");
        }
        return booksByPrice;
    }

    @Override
    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
        List<Book> books = details.showBooks();
        List<Book> booksByAuthorAndCategory = new ArrayList<>();
        for(Book book : books){
            if (book.getAuthor().startsWith(author) | book.getCategory().startsWith(category)){
                booksByAuthorAndCategory.add(book);
            }
        }
        if (booksByAuthorAndCategory.isEmpty()){
            throw new BookNotFoundException("Book Not Found");
        }
        return booksByAuthorAndCategory;
    }

    @Override
    public Book getById(int bookId) throws IdNotFoundException {
        List<Book> books = details.showBooks();
        for(Book book : books){
            if (book.getBookId()==bookId){
                return book;
            }
        }
        throw new IdNotFoundException("Invalid ID");
    }
}
