package com.varxyz.jv200.mod007;

public abstract class Animal { // 추상클래스
	public String type; // 포유류, 조류, 양서류, 파충류 ...
	public boolean eatable;

	public abstract void makeSound();
	
//	public boolean canEat(String str) {
//		return eatable;
//	}
}