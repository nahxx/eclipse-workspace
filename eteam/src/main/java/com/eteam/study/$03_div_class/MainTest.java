package com.eteam.study.$03_div_class;
/**
 * .- Study 할 부분
 * 객체 세분화에 따른 문제점을 이야기하기. Customer에 Saving, Checking 계좌 객체를 담는 변수가 필요하다.
 * @author park
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		
		/*
		 * 유재석은 이자율을 갖는 일반 계좌를 가진다 ex) 일반계좌 이자율 2 초기잔액 50000.0
		 * 유재석은 대출한도를 갖는 마이너스 계좌도 가진다. ex) 초기잔액 30000.0 대출한도 50000.0
		 * 서현진은 이자율을 갖는 일반 계좌를 가진다 ex) 일반계좌 이자율 1.2 초기잔액 20000.0
		 * 
		 * 각각의 고객에 계좌를 등록하고 해당타입의 계좌가 잘들어갔는지 체크하기.
		 */
		
		// 계좌 객체 생성
		SavingAccount sa = new SavingAccount("111-11-1111", 50000.0, 2.0);
		SavingAccount sa2 = new SavingAccount("222-22-2222", 20000.0, 1.2);
		CheckingAccount ca = new CheckingAccount("333-33-3333", 30000.0, 50000.0);
		
		//유재석, 서현진 객체 추가.
		customer.setSavingAccount(sa);
		customer.setCheckingAccount(ca);
		customer2.setSavingAccount(sa2);
		
		System.out.println("유재석의 일반계좌 계좌번호 : " + customer.getSavingAccount().get(0).getAccountNum());
		System.out.println("유재석의 마이너스계좌 계좌번호 : " + customer.getCheckingAccount().get(0).getAccountNum());
		System.out.println("서현진의 일반계좌 계좌번호 : " + customer2.getSavingAccount().get(0).getAccountNum());
	}
}

