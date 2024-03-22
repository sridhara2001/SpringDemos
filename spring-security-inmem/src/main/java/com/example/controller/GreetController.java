package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {
	// for user and admin
	// http://localhost:8080/greet
			@GetMapping("/greet")
			public String greet() {
				return "Have a good Day";
			}
				
			// for user and admin
			// http://localhost:8081/user/books/show
			@GetMapping("/user/books/show")
			public List<String> showBooks(){
				return Arrays.asList("Java","Sring","React");
			}
			
			// for admin
			@GetMapping("/admin/books/in")
			public String addBooks() {
				return "added";
			}
}
