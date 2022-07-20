package com.varxyz.jv200.mod003;
/*
 * 어떤 수를 던졌는데 소수가 아니면 예외처리
 * 예외를 던지면서 예외메시지에 (숫자)는 () * () 출력 ex) 6 = 2 * 3;
 * 
 * 1. 배열로 바꾸기
 * 2. 15 = 1 * 3 * 5 이런식으로 나오게
 * 3. 배열길이 임의로 [50];
 * 4. 제곱근 확인 (100 = 2제곱 또는 5제곱)
 * 5. primeNumber 클래스 새로 만들고 이 클래스는 Prime판별클래스로 바꾸기
 * 6. 조건에 int 넘어갈때도 어떻게 할지 추가
 */

public class PrimeNumber {
	private int num;
	
	public int getNum() {
		return num;
	}
	
	public boolean checkNum(int num) throws PrimeNumException {
		String str = "";
		int n = num;
		int cnt = 0;
		int[] numList = new int[50];
		int idx = 0;
		int i;
		for(i = 2; i < n; i++) {
			if(n % i == 0) {
				numList[idx++] = i;
				cnt++;
			}
		}
		if(n < 2) {
			throw new PrimeNumException("2 이상의 정수를 입력하세요.");
		} else if(cnt < 2) {
			System.out.println(n + "은(는) 소수입니다.");
			return true;
		} else{
			for(int k = 0; k < idx; k++) {
				System.out.println(numList[k]);
			}
			
			str += numList[0] + "X" + numList[idx-1] + "=" + n + ", 따라서 ";
			throw new PrimeNumException(str + n + "은(는) 소수가 아닙니다.");
		}
	}
}
