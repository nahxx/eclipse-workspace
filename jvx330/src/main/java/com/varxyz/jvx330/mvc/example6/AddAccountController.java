package com.varxyz.jvx330.mvc.example6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example6.addAccountController")
@RequestMapping("example6/add_account")
public class AddAccountController {
	
	@GetMapping
	public String addAccountForm(Model model) {
		model.addAttribute("account", new AccountCommand());
		return "example6/add_account";
	}
	
	@ModelAttribute("accountTypeList")
	public List<AccountTypeList> getAccTypeProviderList() {
		List<AccountTypeList> list = new ArrayList<AccountTypeList>();
		list.add(new AccountTypeList("SavingsAccount", 'S'));
		list.add(new AccountTypeList("CheckingAccount", 'C'));
		
		return list;
	}
	
	@PostMapping
	public String addAccount(@ModelAttribute("account") AccountCommand account, Model model) {
		// db처리
		// ...
		// account = accountService.addAccount(account);
		System.out.println(account.getCustomer().getName());
		System.out.println(account.getAccType());
		System.out.println(account.getInitAmount());
		
		model.addAttribute("account", account);
		return "example6/success_add_account";
	}
}
