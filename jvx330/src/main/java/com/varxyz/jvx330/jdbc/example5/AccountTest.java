package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;



public class AccountTest {
	public static void addAccount4(AccountDao dao) {
		System.out.println("[addAccount4()]");
		SavingsAccount account = new SavingsAccount();
		account.setCustomer(new Customer(1003));
		account.setAccountNum("555-55-5555");
		account.setAccType('S');
		account.setBalance(50000);
		account.setInterestRate(0.5);
		dao.addAccount4(account);
		System.out.println("-inserted-");
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Example5Config.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		addAccount4(dao);
	}
	
/*
	public static void findAllAccounts(AccountDao dao) {
		System.out.println("[findAllAccounts()]");
		dao.findAllAccounts().forEach(a -> System.out.println(a));
	}
	
	public static void findAccountByRegDate(AccountDao dao) {
		System.out.println("[findAccountByRegDate()]");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		}catch(ParseException e) {
			e.printStackTrace();
		}
		List<Account> list = dao.findAccountByRegDate(currentDate);
		for(Account account : list) {
			System.out.println(account);
		}
	}
	
	public static void findAccountByAccountNum(AccountDao dao, String accountNum) {
		System.out.println("[findAccountByAccountNum()]");
		Account a = dao.findAccountByAccountNum(accountNum);
		System.out.println(accountNum + "의 잔액 : " + a.getBalance());
	}
	
	public static void countAccounts(AccountDao dao) {
		System.out.println("[countAccounts()]");
		System.out.println("총 계좌 수 : " + dao.countAccounts());
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		findAllAccounts(dao);
		findAccountByRegDate(dao);
		findAccountByAccountNum(dao, "222-22-2222");
		countAccounts(dao);
		

		Account a = new Account();
		a.setCustomerId(1001);
		a.setAccountNum("111-11-1111");
		a.setAccType("S");
		a.setBalance(10000);
		a.setInterestRate(0.3);
		dao.addAccunt(a);
		System.out.println("-inserted-");
		
		
		Account a2 = new Account();
		a2.setCustomerId(1002);
		a2.setAccountNum("222-22-2222");
		a2.setAccType("C");
		a2.setBalance(20000);
		a2.setOverAmount(20000);
		dao.addAccunt(a2);
		System.out.println("-inserted-");
		
		Account a3 = new Account();
		a3.setCustomerId(1003);
		a3.setAccountNum("333-33-3333");
		a3.setAccType("C");
		a3.setBalance(30000);
		a3.setOverAmount(30000);
		dao.addAccunt(a3);
		System.out.println("-inserted-");
		
		Account a4 = new Account();
		a4.setCustomerId(1002);
		a4.setAccountNum("444-44-4444");
		a4.setAccType("S");
		a4.setBalance(40000);
		a4.setInterestRate(0.4);
		dao.addAccunt(a4);
		System.out.println("-inserted-");

		
		context.close();

	}
*/
}
