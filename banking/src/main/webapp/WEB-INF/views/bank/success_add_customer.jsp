<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<header class="header">
		<h1><a href="service">Banking</a></h1>
	</header>
	<div class="wrap">
		<h3>회원가입 성공</h3>
		<p style="text-align:center">
			E-mail : ${customer.userId}<br>
			비밀번호 : ${customer.passwd}<br>
			이름 : ${customer.name}<br>
			주민번호 : ${customer.ssn}<br>
			연락처 : ${customer.phone}
		</p>
		<form action="service" method="get" class="center">
			<input type="submit" value="홈으로 가기"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>