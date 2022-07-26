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
		<h1>header</h1>
	</header>
	<div class="wrap">
		<h3>회원가입 성공</h3>
		<p style="text-align:center">
			E-mail : ${customerCommand.email}<br>
			비밀번호 : ${customerCommand.passwd}<br>
			이름 : ${customerCommand.name}<br>
			주민번호 : ${customerCommand.ssn}<br>
			연락처 : ${customerCommand.phone}
		</p>
	</div>
</body>
</html>