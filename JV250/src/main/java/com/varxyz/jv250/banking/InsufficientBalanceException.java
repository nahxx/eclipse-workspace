package com.varxyz.jv250.banking;

/**
 * 현재 잔고 금액이 부족할 때 사용할 예외 클래스
 * 
 * 1. Exception을 상속받은 이유
 * 제가 예외 클래스를 생성할 때 Exception을 상속받은 이유는 계좌에서 금액과 여러 조건들을 확인하여 출금하는 것은 신중히 고려해야할 사항이라고 생각했기 때문에
 * 실행되기 전에 예외 발생 여부를 확인하고 진행하는 것이 바람직하다고 생각했기 때문입니다.
 * 
 * 2. 예외클래스를 하나만 생성한 이유
 * Exception을 상속받아 클래스를 만들었기 때문에 예외를 처리할 메서드에 throws InsufficientBalanceException을 추가해주어야 했습니다.
 * 그런데 저는 문제의 조건 중 '출금 로직 구현시 제약사항은 반드시 두 계좌가 동일 메소드로 정의될 수 있도록 보장되어야 한다.'는 조건을 충족시키기 위해
 * 출금 메서드를 부모 클래스인 Account 클래스에서 추상메서드로 선언한 뒤 자식 클래스에서 override를 해주었습니다.
 * 따라서 Account 클래스에서 생성한 추상메서드에 throws를 추가해 주어야 했고, 만약 ChackingAccount와 SavingsAccount에서 사용할 예외 클래스를 서로 다르게 지정할 경우
 * throws 예외클래스가 다른 메서드를 두개 생성하고, 각 자식 클래스에도 그 두개의 메서드를 override해주어야 해서 불편하다고 생각해서 예외클래스를 하나만 생성하였습니다.
 *
 */
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
