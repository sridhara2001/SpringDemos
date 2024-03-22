package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Book> books;
		books = bookService.getAll();
        for (Book book : books){
            System.out.println(book);
        }
		
        System.out.println();
        System.out.println("Books By Category");
        System.out.println();
        
        books = bookService.getByCategory("Cricket");
        for (Book book : books){
            System.out.println(book);
        }
        
        System.out.println();
        System.out.println("Books By Less Price");
        System.out.println();
        
        books = bookService.getByPriceLessThan(800);
        for (Book book : books){
            System.out.println(book);
        }
	}

}
