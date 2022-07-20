package com.eteam.study.$08_interface.domain;

import com.eteam.study.$08_interface.service.*;

/**
 * .- Study 할 부분
 * 서비스 객체의 활용하는 이유.
 * 고객이 직접 일처리하기위해서 다니는게 아니라 은행창구 텔러가 움직여주는 역할.
 * 싱글톤 넘어가기 전에 서비스 객체를 매개변수로 던져주는 방식을 통해 개념잡기
 * 
 * 계좌객체는 매번 고객정보가 담긴 객체를 받아와야한다.
 * @author park
 */
public class MainTest {
	public static void main(String[] args) {
		/**
		 * 중요! 고객을 관리하는 서비스를 계좌 객체에도 생성해줘야지만
		 * 계좌 서비스에서도 고객정보를 컨트롤 할 수 있다.
		 * 싱글톤 넘어가기 전에 예제로 써도 괜찮을듯.
		 * 
		 * 제일 처음에 고객정보를 안넘겨주고 해서 뭐가 문제점인지 체크를 해보기!.
		 * 여기서 싱글톤 개념잡으면 좋을듯.
		 */
		CustomerService cService = new CustomerServiceImpl();
		AccountService aService = new AccountServiceImpl(cService);
		
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
		
		//유재석 주민번호로 어떤 계좌가 있는지 조회하기.
		for(Account ac : aService.getAccountBySsn("770321-1585477")) {
			System.out.println("계좌번호 : " + ac.getAccountNum() + "\n계좌주인 : " + ac.getCustomer().getName());
		}
		
		//"222-22-2222" 의 계좌 주인은 누구인지 확인하기.
		System.out.println("계좌번호 222-22-2222의 주인은 : "+aService.getAccountByAccountNum("222-22-2222").getCustomer().getName());
	}
}

