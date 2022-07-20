package com.varxyz.jv200.mod004;

public class CheckArray {
	public static String checkContain(int[] numArr, int[] checkArr) {
		String[] str = {"포함", "일부만 포함", "포함하지 않음"};
		int isContain = 0;
		for(int i = 0; i < checkArr.length; i++) {
			for(int j = 0; j < numArr.length; j++) {
				if(checkArr[i] == numArr[j]) {
					isContain++;
					System.out.print(numArr[j] + "\t");
					break;
				}
			}
		}
		if(isContain == checkArr.length) {
			return str[0];
		} else if(isContain > 0) {
			return str[1];
		} else {
			return str[2];
		}
	}
	
	public static void main(String[] args) {
		// 같은 파일 내에서 메서드 사용
		int[] numArr = {1, 2, 3, 7, 5, 4, 6, 8, 9, 10};
		int[] checkArr1 = {1, 5, 2};
		int[] checkArr2 = {500, 8, 10};
		int[] checkArr3 = {25, 12, 35};
		
		System.out.println(checkContain(numArr, checkArr1));
		System.out.println(checkContain(numArr, checkArr2));
		System.out.println(checkContain(numArr, checkArr3));
	}
}
