package com.varxyz.banking.mvc.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.domain.Customer;

@Service("service/customerService")
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer getCustomerByUserId(String userId) {
		return customerDao.findCustomerByUserId(userId);
	}
	
	public boolean isValidCustomer(String userId, String passwd) {
		return customerDao.isValidCustomer(userId, passwd);
	}
	
	public void checkingLogin(String userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
	    // 로그인상태가 아니라면 로그인 화면으로 이동
		if(userId == null || userId.length() == 0) {
		    response.setContentType("text/html; charset=UTF-8");
		    PrintWriter writer = response.getWriter();
		    writer.println("<script>alert('로그인 후 사용 해주시기 바랍니다.'); location.href='/banking';</script>"); // 경고창 띄우기
		    writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
	    }
	}

}
