package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
	
	@Autowired
	// MemberService에 대해서 자동으로 wired하라는 의미의 어노테이션
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("빈 생성 : " + this);
	}
	
	public void processRequest() {
		memberService.addMember("java", "1111");
	}
}
