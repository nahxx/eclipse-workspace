<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입완료</title>
<style>h1, h3, h4 {text-align: center;} table {margin: 0 auto; width: 500px; border: 1px solid lightgray; border-collapse: collapse;} th, td {height: 30px; padding-left: 10px; border: 1px solid lightgray; text-align: left;} th {width: 20%; background: lavender;} span {color: purple}</style>
</head>
<body>
<%
	String userId = (String)request.getAttribute("userId");
	String passwd = (String)request.getAttribute("passwd");
	String userName = (String)request.getAttribute("userName");
	String ssn = (String)request.getAttribute("ssn");
	String email1 = (String)request.getAttribute("email1");
	String email2 = (String)request.getAttribute("email2");
	String addr1 = (String)request.getAttribute("addr1");
	String addr2 = (String)request.getAttribute("addr2");
%>
	<h1>가입 완료!</h1>
	<h3><span><%=userName %></span>님 가입을 축하드립니다.</h3>
	<h4>가입 정보</h4>
	<table>
		<tr><th>회원아이디</th><td><%=userId%></td></tr>
		<tr><th>비밀번호</th><td><%=passwd %></td></tr>
		<tr><th>이름</th><td><%=userName %></td></tr>
		<tr><th>주민번호</th><td><%=ssn %></td></tr>
		<tr><th>이메일</th><td><%=email1 %>@<%=email2 %></td></tr>
		<tr><th>주소</th><td><%=addr1 %> <%=addr2 %></td></tr>
	</table>

</body>
</html>