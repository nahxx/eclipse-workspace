package com.eteam.study.$02_add_variable;
/**
 * .- Study 할 부분
 * 계좌 클래스 객체의 세분화 필요성
 * 생성자 오버로딩 관련 설명
 * @author park
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		/*
		 * 유재석은 이자율을 갖는 일반 계좌를 가진다 ex)일반계좌 이자율 0.03
		 * 서현진은 대출한도를 갖는 마이너스 계좌를 가진다. ex) 대출한도 30000.0
		 * 생성자를 써서 처리할지는 study하면서 맞춰가기.
		 * 
		 * 각각의 고객에 계좌를 등록하고 해당타입의 계좌가 잘들어갔는지 체크하기.
		 */
	}
}
