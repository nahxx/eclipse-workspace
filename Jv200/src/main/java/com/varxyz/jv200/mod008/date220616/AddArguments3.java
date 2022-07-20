package com.varxyz.jv200.mod008.date220616;

public class AddArguments3 {

	public static void main(String[] args) {
		int sum = 0;
		for (String arg : args) {
			try {
				sum += Integer.parseInt(arg);
			} catch (NumberFormatException nfe){
				System.err.println("[" + arg + "] is not an integer" + " and will not be included in the sum.");
			}
		}
		System.out.println("Sum = " + sum);
	}
}

// 오른쪽 버튼 > run As > Run Configurations > 상단의 arguments 클릭
// > Name 확인(클래스이름과 동일하게) > program arguments에 1 two 3.0 4 입력
// > Run 진행