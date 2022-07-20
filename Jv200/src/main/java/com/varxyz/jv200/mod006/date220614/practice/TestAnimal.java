package com.varxyz.jv200.mod006.date220614.practice;

public class TestAnimal {

	public static void main(String[] args) {
		Animal dog1 = new Dog();
		Animal cat1 = new Cat();
		System.out.println(dog1.makeNoice()); // 멍멍
		System.out.println(cat1.makeNoice()); // 야옹
//		System.out.println(dog1.eat()); // 에러 발생. 접근 불가
//		System.out.println(cat1.like()); // 에러 발생. 접근 불가
		Animal a = new Animal();
		a.getChildMethod(dog1); // 사료
		
		a.getChildMethod(cat1); // 츄르 삼색
	}

}
