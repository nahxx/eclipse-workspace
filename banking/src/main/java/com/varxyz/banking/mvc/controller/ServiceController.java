package com.varxyz.banking.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.dao.Example5Config;
import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.CheckingAccount;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.domain.SavingsAccount;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.CustomerService;

@Controller("controller/ServiceController")
public class ServiceController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	// home 페이지 접속
	@GetMapping("")
	public String home() {
		return "home";
	}
	
	@PostMapping("login")
	public ModelAndView login(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		ModelAndView mav = new ModelAndView();
		boolean isValid = customerService.isValidCustomer(userId, passwd);
		
		if(!isValid) {
			String errMsg = "아이디 또는 비밀번호가 존재하지 않습니다. <br>다시 입력해 주세요.";
			mav.addObject("errMsg", errMsg);
			mav.setViewName("/home");
			return mav;
		}
		
		HttpSession session = request.getSession(true);
	    session.setAttribute("userId", userId);
	    
		mav.setViewName("redirect:/bank/service");
		return mav;
	}
	
	// 서비스 페이지 접속
	@GetMapping("/bank/service")
	public String service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
	    
	    return "bank/service";
	}
	
	// 회원가입 페이지 접속
	@GetMapping("/bank/add_customer")
	public String addCustomerForm() {
		return "bank/add_customer";
	}
	
	// 회원가입 작업 후 성공페이지 이동
	@PostMapping("/bank/add_customer")
	public String addCustomer(Customer customer, Model model) {
		customerService.addCustomer(customer);
		model.addAttribute("customer", customer); // customerCommand를 attribute에 추가함
		
		return "bank/success_add_customer";
	}
	
	// 계좌생성 페이지 접속
	@GetMapping("/bank/add_account")
	public ModelAndView addAccountForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
	    
	    ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("bank/add_account");
		
		return mav;
	}
	
	// 계좌 생성 작업 후 성공페이지 이동
	@PostMapping("/bank/add_account")
	public ModelAndView addAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
	    
		// 계좌 타입, 이자율, 한도, 잔액
		char accType;
		double balance = 0;
		double interestRate = 0.0;
		double overdraftAmount = 0.0;
		if(request.getParameter("accType").equals("SavingsAccount")) {
			accType = 'S';
			interestRate = 0.2;
		} else {
			accType = 'C';
			overdraftAmount = 50000;
		}
		
		// userId로 customer 찾기
		Customer customer = customerService.getCustomerByUserId(request.getParameter("userId"));
		// 랜덤 계좌번호 생성
		String accountNum = "";
		for(int i = 0; i < 11; i++) {
			if(i == 3 || i ==  6) {
				accountNum += "-";
			} else {
				Random random = new Random();
				int num = random.nextInt(10 - 1) + 1;
				accountNum += String.valueOf(num);
			}
		}
		
		// 서비스 호출해서 값넣기 (타입에 따라 다르게)
		Account account = null;
		if(accType == 'S') {
			account = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) account;
			sa.setInterestRate(interestRate);
		} else {
			account = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) account;
			ca.setOverdraftAmount(overdraftAmount);
		}
		account.setAccountNum(accountNum);
		account.setAccType(accType);
		account.setBalance(balance);
		account.setCustomer(customer);
		accountService.addAccount(account);
		
		// jsp로 연결
		ModelAndView mav = new ModelAndView();
		mav.addObject("account", account);
		mav.addObject("customer", customer);
		mav.addObject("accType", String.valueOf(accType));
		mav.setViewName("/bank/success_add_account");
		
		return mav;
	}
	
	// 계좌 목록 페이지 접속
	@GetMapping("/bank/account_list")
	public ModelAndView accountList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동	
	    if(userId == null || userId.length() == 0) {
		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter writer = response.getWriter();
		    writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking';</script>"); // 경고창 띄우기
		    writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("/banking/bank");
			
			return mav;
	    }
	    
	    String name = customerService.getCustomerByUserId(userId).getName();
	    
	    List<Account> list = accountService.getAccountsByUserId(userId);
		String accountList = "<table><tr><th>No.</th><th>계좌번호</th><th>잔액</th></tr>";
		int i = 1;
		for(Account a : list) {
			accountList += "<tr><td>" + i++ + "</td><td>" + a.getAccountNum() + "</td><td>" + a.getBalance() + "</td></tr>";
		}
		accountList += "</table>";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("accountList", accountList);
		mav.setViewName("bank/account_list");
		
		return mav;
	}
	
	// 이체 페이지 접속
	@GetMapping("/bank/transfer")
	public ModelAndView transferForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    if(userId == null || userId.length() == 0) {
		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter writer = response.getWriter();
		    writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking';</script>"); // 경고창 띄우기
		    writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("/banking/bank");
			
			return mav;
	    }
	    
	    List<Account> accList = accountService.getAccountsByUserId(userId);
	    
	    String selectStr = "<select name=\"withdrawNum\">";
	    for(Account a : accList) {
	    	selectStr += "<option value=\"" + a.getAccountNum() + "\">" + a.getAccountNum() + "</option>";
	    }
	    selectStr += "</select>";
	    
	    ModelAndView mav = new ModelAndView();
		mav.addObject("selectStr", selectStr);
		mav.setViewName("bank/transfer");
		
		return mav;
	}
	
	// 이체 작업 후 이체 성공 페이지로 이동
	@PostMapping("/bank/transfer")
	public String transfer(TransferCommand transferCommand, Model model, HttpServletRequest request, HttpServletResponse response) throws InsufficientBalanceException, IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
 		
 		Customer c = customerService.getCustomerByUserId(userId);
	    
	    List<Account> accList = accountService.getAccountsByUserId(userId);
	    String selectStr = "<select name=\"withdrawNum\">";
	    for(Account a : accList) {
	    	selectStr += "<option value=\"" + a.getAccountNum() + "\">" + a.getAccountNum() + "</option>";
	    }
	    selectStr += "</select>";
	    
		if(transferCommand.getDepositNum() == null) {
			String errMsg2 = "입금할 계좌번호를 입력해 주세요.";
			model.addAttribute("errMsg2", errMsg2);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		} else if(transferCommand.getAmount() == 0.0) {
			String errMsg3 = "입금할 금액을 입력해 주세요.";
			model.addAttribute("errMsg3", errMsg3);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		} else if(transferCommand.getPasswd() == null) {
			String errMsg4 = "비밀번호를 입력해 주세요.";
			model.addAttribute("errMsg4", errMsg4);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		}
		
		String withdrawNum = transferCommand.getWithdrawNum();
		String depositNum = transferCommand.getDepositNum();
		double amount = transferCommand.getAmount();
		String passwd = transferCommand.getPasswd();
	    
		Account a1 = null;
		
		// 출금할 계좌
		a1 = accountService.getAccountByAccountNum(withdrawNum);
		if(withdrawNum.equals(depositNum)) {
			String errMsg2 = "같은 계좌로는 입금할 수 없습니다.<br>입금할 계좌번호를 변경해주세요.";
			model.addAttribute("errMsg2", errMsg2);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		} else if(!accountService.isValidAccountByAccountNum(depositNum)) {
			String errMsg2 = "존재하지 않는 계좌번호 입니다. <br> 다시 입력해 주세요.";
			model.addAttribute("errMsg2", errMsg2);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		} else if(a1.getBalance() < amount) {
			String errMsg3 = "잔액이 부족합니다.";
			model.addAttribute("depositNum", depositNum);
			model.addAttribute("errMsg3", errMsg3);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		} else if(!c.getPasswd().equals(passwd)) {
			String errMsg4 = "비밀번호가 틀렸습니다. 다시 입력해 주세요.";
			model.addAttribute("depositNum", depositNum);
			model.addAttribute("amount", (int)amount);
			model.addAttribute("errMsg4", errMsg4);
			model.addAttribute("selectStr", selectStr);
			
			return "bank/transfer";
		}
		
		// 출금 전 금액
		double before = a1.getBalance();
		
		// 출금 후 금액
		double after = 0;
		
		// 입금할 계좌
		Account a2 = accountService.getAccountByAccountNum(depositNum); // 입금할 계좌
		
		accountService.transferAmount(a1, a2, amount);
		
		after = a1.getBalance();
		
		model.addAttribute("transferCommand", transferCommand);
		model.addAttribute("before", (int)before);
		model.addAttribute("after", (int)after);
		
		return "bank/success_transfer";
	}
	
	// 잔액 확인 페이지 접속
	@GetMapping("/bank/checking_balance")
	public ModelAndView checkingBalanceForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    if(userId == null || userId.length() == 0) {
		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter writer = response.getWriter();
		    writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking';</script>"); // 경고창 띄우기
		    writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("/banking/bank");
			
			return mav;
	    }
	    
	    List<Account> accList = accountService.getAccountsByUserId(userId);
	    
	    String selectStr = "<select name=\"accountNum\">";
	    for(Account a : accList) {
	    	selectStr += "<option value=\"" + a.getAccountNum() + "\">" + a.getAccountNum() + "</option>";
	    }
	    selectStr += "</select>";
	    
	    ModelAndView mav = new ModelAndView();
		mav.addObject("selectStr", selectStr);
		mav.setViewName("bank/checking_balance");
		
		return mav;
	}
	
	// 잔액 확인 작업 후 다시 잔액 확인 페이지로 이동
	@PostMapping("/bank/checking_balance")
	public ModelAndView checkingBalance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
		
		String accountNum = request.getParameter("accountNum");
		
//		AnnotationConfigApplicationContext context =
//				new AnnotationConfigApplicationContext(Example5Config.class);
//		
//		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
//		Double balance = dao.findAccountByAccountNum(accountNum).getBalance();
		Double balance = accountService.getAccountByAccountNum(accountNum).getBalance();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("balance", balance.intValue());
		mav.setViewName("bank/checking_balance");
		
		return mav;
	}
	
	// 이자 확인 페이지 접속
	@GetMapping("/bank/checking_interest")
	public ModelAndView checkingInterestForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession(false);
	    String userId = (String) session.getAttribute("userId");
	    
	    // 로그인상태가 아니라면 로그인 화면으로 이동
	    customerService.checkingLogin(userId, request, response);
		
		List<Account> accList = accountService.getAccountsByUserId(userId);
	    
	    String selectStr = "<select name=\"accountNum\">";
	    for(Account a : accList) {
	    	selectStr += "<option value=\"" + a.getAccountNum() + "\">" + a.getAccountNum() + "</option>";
	    }
	    selectStr += "</select>";
	    
	    ModelAndView mav = new ModelAndView();
		mav.addObject("selectStr", selectStr);
		mav.setViewName("bank/checking_interest");
		
		return mav;
	}
	
	// 이자 지급 확인 후 다시 이자 확인 페이지로 이동
	@PostMapping("/bank/checking_interest")
	public String checkingInterest() {
		return "bank/checking_interest";
	}
	
	// 로그아웃
	@GetMapping("/bank/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
}
