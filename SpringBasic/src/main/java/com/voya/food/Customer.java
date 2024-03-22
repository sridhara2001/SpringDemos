package com.voya.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Customer {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.voya.food");
		Waiter waiter = (Waiter) context.getBean("waiter");
		
		List<String> menu = new ArrayList<>();
		menu.add("Puri");
		menu.add("Rice");
		menu.add("Idli");
		List<String> foodItems = waiter.printMenu("i",menu);
		for(String food : foodItems) {
			System.out.println(food);
		}
	}

}
