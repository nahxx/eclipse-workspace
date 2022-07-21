package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 여기 있는 클래스는 설정과 관련된 클래스라는 것을 알려주는 어노테이션
// 스프링이 Bean으로 등록해야할 것을 선언하고 관계를 맺어줌
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
