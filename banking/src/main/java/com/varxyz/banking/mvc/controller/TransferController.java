package com.varxyz.banking.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;
import com.varxyz.banking.mvc.service.AccountService;
import com.varxyz.banking.mvc.service.CustomerService;

//@Controller("controller/TransferController")
public class TransferController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	HttpSession session = request.getSession(false);
    String userId = (String) session.getAttribute("userId");
    
    List<Account> accList = accountService.getAccountsByUserId(userId);
	
	// 이체 페이지 접속
		@GetMapping("/bank/transfer")
		public ModelAndView transferForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		    
		    // 로그인상태가 아니라면 로그인 화면으로 이동
		    if(userId == null || userId.length() == 0) {
			    response.setContentType("text/html; charset=UTF-8");
			    PrintWriter writer = response.getWriter();
			    writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking/bank';</script>"); // 경고창 띄우기
			    writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
			    ModelAndView mav = new ModelAndView();
			    mav.setViewName("/banking/bank");
				
				return mav;
		    }
		    
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
		public String transfer(TransferCommand transferCommand, Model model, HttpServletRequest request) throws InsufficientBalanceException {
			String withdrawNum = transferCommand.getWithdrawNum();
			String depositNum = transferCommand.getDepositNum();
			double amount = transferCommand.getAmount();
			String passwd = transferCommand.getPasswd();
			
			HttpSession session = request.getSession(false);
		    String userId = (String) session.getAttribute("userId");
		    Customer c = customerService.getCustomerByUserId(userId);
		    
		    // 출금할 계좌 선택 태그 문자열
		    String selectStr = "<select name=\"withdrawNum\">";
		    for(Account a : accList) {
		    	selectStr += "<option value=\"" + a.getAccountNum() + "\">" + a.getAccountNum() + "</option>";
		    }
		    selectStr += "</select>";
		    
			Account a1 = null;
			
			// 출금할 계좌
			a1 = accountService.getAccountByAccountNum(withdrawNum);
			if(withdrawNum.equals(depositNum)) {
				String errMsg2 = "같은 계좌로는 입금할 수 없습니다.<br>입금할 계좌번호를 변경해주세요.";
				model.addAttribute("errMsg2", errMsg2);
				model.addAttribute("selectStr", selectStr);
				
				return "bank/transfer";
			} else if(a1.getBalance() < amount) {
				String errMsg3 = "출금 가능한 잔액이 부족합니다.";
				model.addAttribute("errMsg3", errMsg3);
				model.addAttribute("selectStr", selectStr);
				
				return "bank/transfer";
			} else if(c.getPasswd() != passwd) {
				String errMsg4 = "비밀번호가 틀렸습니다. 다시 입력해 주세요.";
				model.addAttribute("errMsg4", errMsg4);
				model.addAttribute("selectStr", selectStr);
				
				return "bank/transfer";
			}
			
			// 출금 전 금액
			double before = a1.getBalance();
			
			// 출금 후 금액
			double after = 0;
			
			/*
			if(a1.getAccType() == 'S') {
				SavingsAccount sa = (SavingsAccount)a1;
				sa.withdraw(amount);
				accountService.updateBalance(sa);
				after = sa.getBalance();
			} else {
				CheckingAccount ca = (CheckingAccount)a1;
				ca.withdraw(amount);
				accountService.updateBalance(ca);
				after = ca.getBalance();
			}
			*/
			
			// 입금할 계좌
			Account a2 = accountService.getAccountByAccountNum(depositNum); // 입금할 계좌
			/*
			if(a2.getAccType() == 'S') {
				SavingsAccount sa = (SavingsAccount)a2;
				sa.deposite(amount);
				accountService.updateBalance(sa);
			} else {
				CheckingAccount ca = (CheckingAccount)a2;
				ca.deposite(amount);
				accountService.updateBalance(ca);
			}
			*/
			
			accountService.transferAmount(a1, a2, amount);
			
			after = a1.getBalance();
			
			model.addAttribute("transferCommand", transferCommand);
			model.addAttribute("before", before);
			model.addAttribute("after", after);
			
			return "bank/success_transfer";
		}
}
