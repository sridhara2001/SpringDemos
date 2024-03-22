package com.voya.food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
	@Autowired
	private IFoodMenu indian;
	
	@Autowired
	private IFoodMenu chinese;
	
	@Autowired
	private IFoodMenu italian;
	
	List<String> printMenu(String choice, List<String> menu) {
		List<String> customerMenu = new ArrayList<>();
		if(choice.equals("i")) {
			customerMenu = indian.showMenu(menu);
		}
		if(choice.equals("c")) {
			customerMenu = chinese.showMenu(menu);
		}
		if(choice.equals("t")) {
			customerMenu = italian.showMenu(menu);
		}
		return customerMenu;
	}
}
