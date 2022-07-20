package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod010/list_user.do")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserService.getInstance();
	RequestDispatcher dispatcher = null;
	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 비즈니스 서비스 호출
		List<User> userList = userService.getAllUsers();
		
		// 2. 리스트
		List<String> list = new ArrayList<>();
		String str = null;
		for(User user : userList) {
			str = "<td>" + user.getUserId() + "</td>" + "<td>" + user.getPasswd() + "</td>" + 
					"<td>" + user.getUserName() + "</td>" + "<td>" + user.getSsn() + "</td>" + 
					"<td>" + user.getEmail() + "</td>" + "<td>" + user.getAddr() + "</td>";
			list.add(str);
		}
		
		// 3. NextPage
		request.setAttribute("list", list);
		dispatcher = request.getRequestDispatcher("list_user.jsp");
		dispatcher.forward(request, response);
	}
}
