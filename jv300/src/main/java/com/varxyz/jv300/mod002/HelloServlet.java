package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청방식 (doGet은 부모의 메서드(파라미터도 부모가 설정한 것 그대로)로 오버라이딩한 것이다.)
		// 요청이 들어오면 응답할 때 HTML이 필요하다.
		String pageTitle = "Hello world";
		response.setContentType("text/html; charset=UTF-8"); // 응답 타입 지정(html로 보내고 UTF-8로 적용하겠다)
		// response는 interface, 따라서 메서드의 바디는 비어있다. => 톰캣에서 response를 상속받아 클래스를 생성하여 메서드의 기능을 구체화한다.(pholymorphism)
		// 즉, 이 코드는 변하지 않고 웹 컨테이너(톰캣 등)가 각각 알아서 메서드를 오버라이딩으로 구체화해서 기능을 작동시킨다.
		
		// HTML 작성
		PrintWriter out = response.getWriter(); // PrintWriter는 Writer의 자식 중 하나
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3>Welcom to 서블릿 프로그래밍</h3>");
		out.println("</body></html>");
		out.close(); // 끝나면 닫아줘야 함
		
		//Servlet은 웹 컴포넌트. 메서드가 있다는 걸 웹 컨테이너(톰켓 등)가 알아야 한다.
	}
}
