<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- <%@ : direct 태그 --%>
<%! 
	private static final String DEFAULT_NAME = "world";

	public void jspInit() {
		
	}
%>
<%-- <%! : 자바의 멤버변수나 메서드 선언하는 태크 --%>

<!DOCTYPE html>
<!-- doGet 메서드의 내용이 JSP.
즉, 서블릿처럼 생각하면 JSP는 서비스 메서드가 오버라이딩된 것 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 이것은 JSP 주석입니다. --%>
<%
	String name = request.getParameter("userName");
	if(name == null || name.length() == 0) {
		name = DEFAULT_NAME;
	}
	out.println("name" + name);
%>
<%-- <% : 자바코드 적는 태그 --%>
<h3>Hello, <%=name%></h3> <%-- <%= : 값 출력 --%>
</body>
</html>