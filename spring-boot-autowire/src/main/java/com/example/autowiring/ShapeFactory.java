package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	@Autowired
	@Qualifier("rectangle")
	private IShape shape;
	
	@Autowired
	private IShape triangle;
	
	@Autowired
	private IShape shaper;
	
	public ShapeFactory(IShape shaper) {
		super();
		this.shaper = shaper;
	}

//	public IShape getShape() {
//		return shape;
//	}
//
//	public void setShape(IShape shape) {
//		this.shape = shape;
//	}

	public void printArea(String choice, int x, int y) {
		System.out.println("Printing Area");
		if(choice.equals("r")) {
			shape.area(x, y);
		}
		if(choice.equals("t")) {
			triangle.area(x, y);
		}
		if(choice.equals("s")) {
			shaper.area(x, y);
		}
	}
}
