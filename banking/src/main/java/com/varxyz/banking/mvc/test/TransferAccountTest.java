package com.varxyz.banking.mvc.test;

import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

public class TransferAccountTest {
	
	public static void main(String[] args) throws InsufficientBalanceException {
		/**
		 * 이슈
		 * 1. 출금할 계좌번호가 사용자가 가진 계좌번호여야 한다.
		 * 2. 입금할 계좌번호가 존재하는 계좌번호여야 한다.
		 * 3. 출금할 계좌번호와 입금할 계좌번호가 동일 계좌번호이면 안된다.
		 * 4. 0원이나 0원보다 적은 금액을 이체하려고하면 안된다.
		 * 5. 출금할 계좌의 잔액이 이체금액보다 커야 한다.
		 * 
		 * 위의 조건을 만족하지 못할 경우 false를 반환한다.
		 * 정상적으로 출금이 되었을 경우 true값을 반환한다.
		 */
		TransferAccount transferAccount = new TransferAccount(); 
		boolean transfer = transferAccount.transfer(10000, "출금 계좌번호", "입금 계좌번호");
	}
}
