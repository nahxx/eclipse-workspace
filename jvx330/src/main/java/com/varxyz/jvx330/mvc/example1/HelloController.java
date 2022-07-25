package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/example1/sayHello")	// servlet의 get방식과 같다
	public ModelAndView sayHello() {
		String greeting = "Hello! 스프링 MVC";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello"); // 해당 경로의 jsp 페이지로 넘어감
		mav.addObject("greeting", greeting); // request.setAttribute()와 같다
		
		return mav;
	}
}
