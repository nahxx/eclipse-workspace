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
		<h3>로그인</h3>
		<form action="login" method="post"> <!-- 현재 login.jsp가 example3에 있다. action에 적어줄 컨트롤러 경로도 같은 경로에 있으므로 login만 쓰면 된다 -->
			<label>아이디</label><input type="text" name="userId"/><br>
			<label>비밀번호</label><input type="password" name="passwd"/><br>
			<input type="submit" value="로그인"/>
		</form>
	</div>

</body>
</html>