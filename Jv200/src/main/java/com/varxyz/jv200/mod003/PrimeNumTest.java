package com.varxyz.jv200.mod003;

import java.util.Scanner;

public class PrimeNumTest {

	public static void main(String[] args) {
		System.out.println("프로그램 시작!");
		PrimeNumber pn = new PrimeNumber();
		try {
			pn.checkNum(30);
		} catch (PrimeNumException e) {
			System.err.println(e.getMessage());
		}
		
//		while(true) {
//			System.out.print("값 입력(2 이상 정수 입력 // 종료 시 0 입력)>> ");
//			Scanner sc = new Scanner(System.in);
//			int n = sc.nextInt();
//			
//			if(n == 0) {
//				System.out.println("프로그램 종료!");
//				break;
//			}
//			
//			PrimeNumber pn = new PrimeNumber();
//			try {
//				pn.checkNum(n);
//			} catch (PrimeNumException e) {
//				System.err.println(e.getMessage());
//			}
//		}
	}

}
