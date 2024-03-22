package com.spring.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VehicleMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.setter");
		Vehicle vehicle = (Vehicle) context.getBean("vehicle");
		System.out.println(vehicle);
	}

}
