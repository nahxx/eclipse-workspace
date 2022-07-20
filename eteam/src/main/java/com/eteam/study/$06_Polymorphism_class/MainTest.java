package com.eteam.study.$06_Polymorphism_class;

import com.eteam.study.$06_Polymorphism_class.CheckingAccount;
import com.eteam.study.$06_Polymorphism_class.Customer;
import com.eteam.study.$06_Polymorphism_class.SavingAccount;
import com.eteam.study.$06_Polymorphism_class.Account;

/**
 * .- Study 할 부분
 * 다형성, 캐스팅과 instanceof 사용
 * @author park
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		
		// 부모 클래스 Account를 참조하는 SavingAccount 객체 생성 
		Account a1 = new SavingAccount("111-11-1111", 50000.0, 2.0);
		Account a2 = new SavingAccount("222-22-2222", 20000.0, 1.2);
		// 부모 클래스 Account를 참조하는 CheckingAccount 객체 생성 
		Account a3 = new CheckingAccount("333-33-3333", 30000.0, 50000.0);
		
		// 계좌의 주인 지정
		a1.setCustomer(customer);
		a2.setCustomer(customer2);
		a3.setCustomer(customer);
		
		// 계좌의 인스턴스타입을 확인하여 고객 계좌리스트에 계좌 추가
		if(a1 instanceof SavingAccount) {
			SavingAccount sa = (SavingAccount) a1;
			customer.setSavingAccount(sa);
		}
		if(a2 instanceof SavingAccount) {
			SavingAccount sa = (SavingAccount) a2;
			customer2.setSavingAccount(sa);
		}
		if(a3 instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount) a3;
			customer.setCheckingAccount(ca);
		}
		
		// 제대로 계좌의 주인이 지정되었는지 확인
		System.out.println(a1.getAccountNum() + "의 주인 : " + a1.getCustomer().getName());
		System.out.println(a2.getAccountNum() + "의 주인 : " + a2.getCustomer().getName());
		System.out.println(a3.getAccountNum() + "의 주인 : " + a3.getCustomer().getName());
		
		// CheckingAccount 입금 메소드 오버라이딩 되었는지 체크
		if(a3 instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount) a3;
			ca.deposite(2000.0);
			System.out.println("유재석의 마이너스계좌 계좌잔액 : " + customer.getCheckingAccount().get(0).getBalance());
		}
	}
}

