package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Book> books = bookService.getAll();
		for(Book book : books) {
			System.out.println(book);
		}
		
		System.out.println("---------------------");
		System.out.println();
		
		books = bookService.getByPriceLessThan(700);
		for(Book book : books) {
			System.out.println(book);
		}
		
		System.out.println("---------------------");
		System.out.println();
		
		Book book = bookService.getById(18);
		System.out.println(book);
		
	}

}
