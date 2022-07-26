package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistController {
	
	@GetMapping("/example2/step1") // get 방식
	public String handleStep1() {
		return "example2/step1"; // 약관 페이지
	}
	
	@PostMapping("/example2/step2") // post 방식
	public String handleStep2() {
		return "example2/step2"; // 회원가입 페이지
	}
	
	@PostMapping("/example2/step3") // post 방식
	public String handleStep3() {
		return "example2/step3"; // 가입 후 성공 페이지
	}
}
