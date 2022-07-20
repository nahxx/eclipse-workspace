package com.eteam.study.$05_abstract_class;
/**
 * .- Study 할 부분
 * 추상클래스에 대한 이해 추상메소드에 대한 이해가 필요할듯.
 * 메인에 대한 내용은 이전단계에서 추가할 내용이 없음.
 * @author park
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		
		SavingAccount sa = new SavingAccount("111-11-1111", 50000.0, 2.0);
		SavingAccount sa2 = new SavingAccount("222-22-2222", 20000.0, 1.2);
		CheckingAccount ca = new CheckingAccount("333-33-3333", 30000.0, 50000.0);
		
		customer.setSavingAccount(sa);
		customer.setCheckingAccount(ca);
		customer2.setSavingAccount(sa2);
		
		//부모객체의 메소드인 AccountNum을 가져올수 있다.
		System.out.println("유재석의 일반계좌 계좌번호 : " + customer.getSavingAccount().get(0).getAccountNum());
		System.out.println("유재석의 마이너스계좌 계좌번호 : " + customer.getCheckingAccount().get(0).getAccountNum());
		System.out.println("서현진의 일반계좌 계좌번호 : " + customer2.getSavingAccount().get(0).getAccountNum());
		
		//CheckingAccount 입금 메소드 오버라이딩 되었는것 체크.
		ca.deposite(2000.0);
		System.out.println("유재석의 마이너스계좌 계좌잔액 : " + customer.getCheckingAccount().get(0).getBalance());
	}
}

