package com.example.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	//bean definitions
	@Bean
	public Chinese getChinese() {
		return new Chinese();
	}
	
	@Bean
	public Indian getIndian() {
		return new Indian();
	}
	
	@Bean
	public Italian getItalian() {
		return new Italian();
	}
	
	@Bean
	Waiter getWaiter() {
		Waiter waiter = new Waiter();
		waiter.setIndian(getIndian());
		return waiter;
	}
	
}
