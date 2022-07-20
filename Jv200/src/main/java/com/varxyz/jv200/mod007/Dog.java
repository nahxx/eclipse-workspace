package com.varxyz.jv200.mod007;

public class Dog extends Animal {
	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
	
	/*
	@Override
	public boolean canEat(String str) {
		String[] noEatFoods = {"과일씨", "카페인", "초콜릿", "알콜", "포도", "우유"};
		for(String food : noEatFoods ) {
			if(str == food) {
				eatable = false;
				break;
			} else {
				eatable = true;
			}
		}
		return eatable;
	}
	*/
}
