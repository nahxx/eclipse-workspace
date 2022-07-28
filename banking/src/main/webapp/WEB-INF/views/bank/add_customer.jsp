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
		<h1><a href="/banking">Banking</a></h1>
	</header>
	<div class="wrap">
		<h3>회원가입</h3>
		<form action="add_customer" method="post" class="signinForm">
			<label>
				<span>아이디</span>
				<input type="text" name="userId"/>
			</label>
			<label>
				<span>비밀번호</span>
				<input type="password" name="passwd"/>
			</label>
			<label>
				<span>이름</span>
				<input type="text" name="name"/>
			</label>
			<label>
				<span>주민번호</span>
				<input type="text" name="ssn"/>
			</label>
			<label>
				<span>연락처</span>
				<input type="text" name="phone"/>
			</label>
			<input type="submit" value="회원가입"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>