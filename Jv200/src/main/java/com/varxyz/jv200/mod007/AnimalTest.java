package com.varxyz.jv200.mod007;

public class AnimalTest {

	public static void main(String[] args) {
		Animal animal1 = new Dog();
		Animal animal2 = new Cat();
		if(animal1 instanceof Dog) {
			Dog d = (Dog) animal1;
			d.makeSound(); // 멍멍
//			System.out.println(d.canEat("초콜릿")); // false
//			System.out.println(d.canEat("사과")); // true
		}
		if(animal2 instanceof Cat) {
			Cat c = (Cat) animal2;
			c.makeSound(); // 야옹
			System.out.println(c.type); // 포유류
		}
	}

}
