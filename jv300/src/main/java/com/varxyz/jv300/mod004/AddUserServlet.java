package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod004/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ID = "hello";
	private static final String DEFAULT_FW = "world";
	private static final String DEFAULT_NAME = "KNH";
	private static final String DEFAULT_SSN = "940111";
	private static final String DEFAULT_EMAIL1 = "hello";
	private static final String DEFAULT_EMAIL2 = "naver.com";
	private static final String DEFAULT_CONCERNS = "empty";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("userId");
		if(id == null || id.length() == 0) {
			id = DEFAULT_ID;
		}
		String passwd = request.getParameter("passwd");
		if(passwd == null || passwd.length() == 0) {
			passwd = DEFAULT_FW;
		}
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		String ssn = request.getParameter("ssn");
		if(ssn == null || ssn.length() == 0) {
			ssn = DEFAULT_SSN;
		}
		String email1 = request.getParameter("email1");
		if(email1 == null || email1.length() == 0) {
			email1 = DEFAULT_EMAIL1;
		}
		String email2 = request.getParameter("email2");
		if(email2 == null || email2.length() == 0) {
			email2 = DEFAULT_EMAIL2;
		}
		String[] concerns = request.getParameterValues("concerns");
		String con = "";
		if(concerns == null || email2.length() == 0) {
			con = DEFAULT_CONCERNS;
		}else {
			for(int i = 0; i < concerns.length; i++) {
				con += concerns[i];
				if(i == concerns.length - 1) {
					break;
				} else {
					con += ", ";
				}
			}
		}
		String pageTitle = "회원가입 정보확인";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // PrintWriter는 Writer의 자식 중 하나
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title>");
		out.println("<style>h3 {text-align: center;} table {margin: 0 auto; width: 500px; border: 1px solid lightgray; border-collapse: collapse;} th, td {height: 30px; padding-left: 10px; border: 1px solid lightgray; text-align: left;} th {width: 20%; background: lavender;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> "+ pageTitle +"</h3>");
		out.println("<table>");
		out.println("<tr><th>회원아이디</th><td>" + id + "</td></tr>");
		out.println("<tr><th>비밀번호</th><td>" + passwd + "</td></tr>");
		out.println("<tr><th>이름</th><td>" + name + "</td></tr>");
		out.println("<tr><th>주민번호</th><td>" + ssn + "</td></tr>");
		out.println("<tr><th>이메일</th><td>" + email1 + "@" + email2 + "</td></tr>");
		out.println("<tr><th>관심분야</th><td>" + con + "</td></tr>");
		out.println("</table></body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
