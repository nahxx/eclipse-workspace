package com.varxyz.jv300.mod006;

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

@WebServlet("/mod006/add_user.do")
public class AddUserServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 홈 파라메터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		// 2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(userId == null || userId.length() == 0) {
			errorMsgs.add("id는 필수입력 정보입니다.");
		}
		if(passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		if(userName == null || userName.length() == 0) {
			errorMsgs.add("이름은 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) { // 에러가 있으면
			request.setAttribute("userId", userId);
			request.setAttribute("passwd", passwd);
			request.setAttribute("userName", userName);
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			// webapp 밑에 error 폴더 생성
			dispatcher.forward(request, response); // 해당 페이지로 가게 됨
			return;
		}
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn(ssn);
		user.setEmail(email1 + "@" + email2);
		user.setAddr(addr1 + " " + addr2);
		
		// 3. 비즈니스 서비스 호출
		userService = UserService.getInstance();
		userService.addUser(user);
		
		// 4. NextPage
		request.setAttribute("userId", userId);
		request.setAttribute("passwd", passwd);
		request.setAttribute("userName", userName);
		request.setAttribute("ssn", ssn);
		request.setAttribute("email1", email1);
		request.setAttribute("email2", email2);
		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response); // 해당 페이지로 가게 됨
	}

}
