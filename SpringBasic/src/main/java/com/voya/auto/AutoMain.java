package com.voya.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.voya.auto");
		Performer performer = (Performer) context.getBean("performer");
		performer.playMusic("v", "Playing Violin");
	}

}
