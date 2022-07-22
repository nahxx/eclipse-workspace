package com.varxyz.jvx330.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecycle.example1.Dog;
import com.varxyz.jvx330.lifecycle.example2.Eagle;
import com.varxyz.jvx330.lifecycle.example3.Goat;
import com.varxyz.jvx330.lifecycle.example3.Horse;

@Configuration
public class AppConfig {
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
		/*
		 * xml로 적으면 아래 코드
		 <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
		 	<constructor-arg index="0" type="java.lang.String" value="플루토"/>
		 	<property name="name" value="볼트"/>
		 </bean>
		 */
	}
	
	@Bean(initMethod = "attachWings", destroyMethod = "detachWings")
	// bean 속성이 세팅되면 initMethd 호출하고 bean 종료 전에 destroyMethod 호출
	// 이렇게 하면 기존 파일을 건드리지 않아도 됨
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("에디");
		return e;
	}
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
}
