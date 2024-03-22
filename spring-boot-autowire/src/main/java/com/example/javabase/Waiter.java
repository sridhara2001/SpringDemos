package com.example.javabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Waiter {
	@Autowired
	@Qualifier("getIndian")
	private IFoodMenu indian;
	
	@Autowired
	@Qualifier("getChinese")
	private IFoodMenu chinese;
	
	@Autowired
	@Qualifier("getItalian")
	private IFoodMenu italian;
	
	public void setIndian(IFoodMenu indian) {
		this.indian = indian;
	}

	public void setChinese(IFoodMenu chinese) {
		this.chinese = chinese;
	}

	public void setItalian(IFoodMenu italian) {
		this.italian = italian;
	}

	public List<String> printMenu(String choice) {
		List<String> customerMenu = new ArrayList<>();
		if(choice.equals("i")) {
			customerMenu = indian.showMenu();
		}
		if(choice.equals("c")) {
			customerMenu = chinese.showMenu();
		}
		if(choice.equals("t")) {
			customerMenu = italian.showMenu();
		}
		return customerMenu;
	}
}
