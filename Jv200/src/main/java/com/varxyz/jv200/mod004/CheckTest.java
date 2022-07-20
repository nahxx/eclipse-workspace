package com.varxyz.jv200.mod004;

public class CheckTest {
	public static void main(String[] args) {
		int[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] checkArr1 = {1, 9, 2};
		int[] checkArr2 = {1000, 10, 4};
		int[] checkArr3 = {125, 14, 75};
		
		// 다른 파일 but 같은 패키지 내에서 메서드 사용
		CheckArray arr = new CheckArray();
		System.out.println(arr.checkContain(numArr, checkArr1));
		System.out.println(arr.checkContain(numArr, checkArr2));
		System.out.println(arr.checkContain(numArr, checkArr3));
	}
	
}
