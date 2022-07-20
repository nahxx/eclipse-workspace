package com.varxyz.jv300.mod010;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod010/update_user.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserService.getInstance();
	RequestDispatcher dispatcher = null;
	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 홈 파라메터 얻기
		String userId = request.getParameter("id");
		
		// 2. 유효성 검증 및 변환
		
		// 3. 비즈니스 서비스 호출
		User user = userService.getUser(userId);
		
		// 4. NextPage
		request.setAttribute("user", user);
		dispatcher = request.getRequestDispatcher("update_user.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 홈 파라메터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		// 2. 유효성 검증 및 변환
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn(ssn);
		user.setEmail(email);
		user.setAddr(addr);
		
		// 3. 비즈니스 서비스 호출
		userService.updateUser(user);
		
		// 4. NextPage
		request.setAttribute("user", user);
		dispatcher = request.getRequestDispatcher("updated.jsp");
		dispatcher.forward(request, response);
	}

}
