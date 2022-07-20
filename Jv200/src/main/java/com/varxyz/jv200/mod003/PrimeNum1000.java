package com.varxyz.jv200.mod003;

public class PrimeNum1000 {

	public static void main(String[] args) {
//		 1~1000 중 소수 출력하기
		for(int i = 2; i <= 1000; i++) {
			int j;
			for(j = 2; j <= i; j++) {
				if(i % j == 0) {
					break;
				}
			}
			if(i == j) {
				System.out.println(i);
			}
		}
	}

}
