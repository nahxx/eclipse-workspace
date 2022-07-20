package com.varxyz.jv200.mod004;

public class CreateImoji {
	public int numA(int n) {
		int randomNum = ((int)(Math.random() * n));
		return randomNum;
	}
	public static String testImoji() {
		String[] imoji = {"동그라미", "삼각형", "사각형", "오각형", "육각형", "팔각형", "별"}; 
		CreateImoji cr = new CreateImoji();
		while(true) {
			int num1 = cr.numA(7);
			int num2 = cr.numA(1000);
			System.out.println("num1 : " + num1 + ", num2 : " + num2);
			if(num1 == 0 && num2 < 700) { // 확률 70%
				return imoji[num1];
			} else if(num1 == 1 & num2 < 500) { // 확률 50%
				return imoji[num1];
			} else if(num1 == 2 & num2 < 300) { // 확률 30%
				return imoji[num1];
			} else if(num1 == 3 & num2 < 50) { // 확률 5%
				return imoji[num1];
			} else if(num1 == 4 & num2 < 10) { // 확률 1%
				return imoji[num1];
			} else if(num1 == 5 & num2 < 5) { // 확률 0.5%
				return imoji[num1];
			} else if(num1 == 6 & num2 < 1) { // 확률 0.1%
				return imoji[num1];
			} else {
				continue;
			}
		}
	}

	public static void main(String[] args) {
		// 같은 파일 내에서 메서드 사용하기
		System.out.println(testImoji());
	}
}
