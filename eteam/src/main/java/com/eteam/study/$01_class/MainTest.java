package com.eteam.study.$01_class;
/**
 * .- Study 할 부분
 * 객체에 대한 개념 익히기.
 * 객체에 대한 속성 메소드의 기능 익숙해지기.
 * @author park
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Customer customer = new Customer("유재석", "770321-1585477", "010-5524-8546", "mudo001", "mudo001");
		Account account = new Account("111-11-1111", 4000.0);
		/**
		 * Q2. 고객1명과 계좌를 2개더 생성 해서한다.
		 *   고객정보 : 
		 *   이름 : 서현진 주민번호 : 850405-2582755 전화번호 : 010-5528-5548 아이디 : jin5548 비번 : a5548   
		 *   서현진 고객의 계좌번호 : 333-33-3333
		 *   서현진 고객의 초기잔액 : 20000.0
		 *   유재석 고객 추가 계좌정보 : 222-22-2222 , 잔액 : 50000.0
		 */
		Customer customer2 = new Customer("서현진", "850405-2582755", "010-5528-5548", "jin5548", "a5548");
		Account account2 = new Account("222-22-2222", 50000.0);
		Account account3 = new Account("333-33-3333", 20000.0);
		
		//객체를 바로 프린트 해서 객체는 주소값(레퍼런스)를 가지고 있다고 설명.
		System.out.println("고객의 주소값 표기 : ");
		System.out.println(customer);
		System.out.println(account);
		System.out.println("=================");
		
		//객체에 담긴 이름을 알기 위해서 바로 속성 값을 가져올 수 없으니 메소드를 활용하여서 출력.
		System.out.println("고객명 : " + customer.getName());
		System.out.println("계좌번호 : " + account.getAccountNum() + " '해당계좌의 주인은 정해져 있지 않은 상태.'");
		System.out.println("=================");
		
		//한명의 고객이 한개의 계좌를 갖기 위해서 setAccount 메소드를 활용해서 계좌 추가.
		customer.setAccount(account);
		
		//한명의 고객의 여러계좌중에 첫번째에 있는 계좌의 계좌번호를 화면에 출력해준다.
		System.out.println("유재석 고객의 여러계좌중 첫번째 계좌의 계좌번호는 ? ");
		System.out.println(customer.getAccount().get(0).getAccountNum());
		System.out.println("=================");
		
		
		/**
		 * Q3. 유재석 고객에 222계좌를 서현진 고객에 333계좌를 추가한다.
		 */
		customer.setAccount(account2);
		customer2.setAccount(account3);
		
		System.out.println("유재석 고객의 계좌 갯수 : " +customer.getAccountListCount());
	}
}
