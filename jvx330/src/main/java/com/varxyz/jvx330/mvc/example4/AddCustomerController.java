package com.varxyz.jvx330.mvc.example4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("example4/addCustomerController")
public class AddCustomerController {
	
	@GetMapping("/example4/add_customer")
	public String addCustomerForm() {
		return "example4/add_customer";
	}
	
	@PostMapping("/example4/add_customer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
		/* 파라미터
		 - customerCommand를 넣으면 스프링이 자동으로 파라미터를 받아 적용해준다.
		   별도로 getParameter 할 필요가 없음
		 - 파라미터로 Model을 넣으면 스프링이 자동으로 Model을 만들어준다.
		   내가 따로 생성할 필요가 없음.
		   단, Bean이어야 함.
		*/
		System.out.println(customerCommand.getEmail());
		model.addAttribute("customerCommand", customerCommand); // customerCommand를 attribute에 추가함
		return "example4/success_add_customer";
	}
}
