package com.varxyz.cafe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("homeController")
public class HomeController {
	
	 // home 페이지 접속
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}
