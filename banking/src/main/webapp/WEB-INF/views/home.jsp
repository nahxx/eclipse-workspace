<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<header class="header">
		<h1><a href="/banking">Banking</a></h1>
	</header>
	<div class="wrap login-wrap">
		<h3>나나은행</h3>
		<form action="login" method="post" class="login">
			<label>
				<span>아이디</span>
				<input type="text" name="userId">
			</label>
			<label>
				<span>비밀번호</span>
				<input type="password" name="passwd">
			</label>
			<c:if test="${errMsg.length() > 0}">
				<p style="color:red">${errMsg}</p>
			</c:if>
			<input type="submit" value="로그인"/>
		</form>
		<form action="bank/add_customer" method="get" class="signin">
			<input type="submit" value="회원가입"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Nana</strong></p>
	</footer>
</body>
</html>
