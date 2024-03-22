package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;
    
    public void addBook(Book book) {
    	bookRepository.addBook(book);
    }

    public void updateBook(int bookId, double price) {
    	bookRepository.updateBook(bookId, price);
    }

    public void deleteBook(int bookId) {
    	bookRepository.deleteBook(bookId);
    }

    public List<Book> getAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
       List<Book> books = bookRepository.findByAuthorContains(author);
       return books;
    }

    public List<Book> getByCategory(String category) throws BookNotFoundException {
       return null;
    }

    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
    	 List<Book> books = bookRepository.findByPriceLessThan(price);
         return books;
    }

    public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
    	 List<Book> books = bookRepository.findByAuthorContainsAndCategory(author, category);
         return books;
    }

    public Book getById(int bookId) throws IdNotFoundException {
        Book book = bookRepository.findById(bookId);
        return book;
    }
}
