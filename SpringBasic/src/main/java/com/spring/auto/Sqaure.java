package com.spring.auto;

import org.springframework.stereotype.Component;

@Component("shaper")
public class Sqaure implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Area of square "+x*x);
	}

}
