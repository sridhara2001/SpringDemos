package com.example.javabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

public class Chinese implements IFoodMenu {

	@Override
	public List<String> showMenu() {
		// TODO Auto-generated method stub
		return Arrays.asList("gobi","samosa","tikka");
	}

	
	
}
