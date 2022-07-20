package com.eteam.study.$10_exception_class.domain;

import com.eteam.study.$10_exception_class.service.*;


/**
 * .- Study 할 부분
 * 예외처리 방법 이해하기.
 * checked 예외처리 unchecked 예외처리 확인하기 
 * @author park
 */
public class MainTest {
	
	public static void main(String[] args) {
		/**
		 * 싱글톤으로 객체를 받아와서 서비스 역할하는 것.
		 */
		CustomerService cService = CustomerServiceImpl.getInstance();
		AccountService aService = AccountServiceImpl.getInstance();
		
		//고객생성
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		
		//생성한 고객을 서비스객체를 통해 등록한다.
		cService.addCustomer(customer);
		cService.addCustomer(customer2);
		
		//Account 서비스 객체를 활용하여 계좌 객체 생성
		//아직까지 계좌의 주인은 알 수 없다.
		Account a1 = aService.createSavingAccount("111-11-1111", 50000.0, 2.0);
		Account a2 = aService.createSavingAccount("222-22-2222", 20000.0, 1.2);
		Account a3 = aService.createCheckingAccount("333-33-3333", 30000.0, 50000.0);
		
		//Account 서비스 객체 계좌를 등록한다.
		aService.addAccount(a1);
		aService.addAccount(a2);
		aService.addAccount(a3);
		
		//Account 서비스 객체를 통해 계좌주인이 누구인지 매칭 시켜준다.
		aService.addAccount(a1, "770321-1585477");
		aService.addAccount(a2, "850405-2582755");
		aService.addAccount(a3, "770321-1585477");

		/**
		 * "333-33-3333" 의 계좌 주인은 누구인지 확인하고 출금을 진행해보자.
		 * 오류가 날것이다 왜 오류가 나는지 생각해보자
		 */
		System.out.println("계좌번호 333-33-3333의 주인은 : "+aService.getAccountByAccountNum("333-33-3333").getCustomer().getName());
		Account acc = aService.getAccountByAccountNum("333-33-3333");
		if (acc instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount) acc;
			ca.withdraw(90000.0);
			System.out.println(ca.getBalance());
		}
	}
}

