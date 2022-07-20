package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod004/hello.do")
public class FormBasedHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "world";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		// form에서 input의 userName 받아옴
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		String pageTitle = "Hello world";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // PrintWriter는 Writer의 자식 중 하나
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3>안녕하세요. " + name +"</h3>");
		out.println("</body></html>");
		out.close();
	}
	// http://localhost:8080/jv300/mod004/form.html 에 들어가서
	// input박스에 이름 입려한 다음 확인 버튼을 누르면
	// http://localhost:8080/jv300/mod004/hello.do?userName=유비 로 넘어가서 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
