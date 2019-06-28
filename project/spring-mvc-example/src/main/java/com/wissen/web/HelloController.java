package com.wissen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping(value = "/hello.htm")
	public ModelAndView handleHelloRequest(@RequestParam String name) {
		ModelAndView mav = new ModelAndView();
		
		String res = "Hello " + name;
		
		mav.addObject("message", res);
		
		mav.setViewName("welcome");
		
		return mav;
	}
	
}
