package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	
	@RequestMapping("/greet")
	public String greetUser(Model model) {
		// call service layer from here
		// add attribute and send to next page
		model.addAttribute("message", "Great Day");
		return "success";
	}
	
	@RequestMapping("/hello")
	public String sayHello(ModelMap model) {
		// call service layer from here
		// add attribute and send to next page
		model.addAttribute("message", "Hello!! Have a great day");
		return "success";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcomeUser() {
		ModelAndView modelAndView = new ModelAndView("success","message","Welcome to MVC");
		return modelAndView;
	}
}
