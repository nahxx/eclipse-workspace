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
		<h1><a href="service">Banking</a></h1>
		<ul class="gnb">
			<li><a href="add_account">계좌생성</a></li>
			<li><a href="account_list">계좌목록</a></li>
			<li><a href="transfer">계좌이체</a></li>
			<li><a href="checking_balance">잔액조회</a></li>
			<li><a href="checking_interest">이자조회</a></li>
			<li><a href="logout">로그아웃</a></li>
		</ul>
	</header>
	<div class="wrap">
		<h3><span>${name}</span> 님의 계좌목록</h3>
		<!-- <form action="account_list" method="post" class="center">
			<label>
				<span>찾을 사용자 아이디</span>
				<input type="text" name="userId"/>
			</label><br>
			<input type="submit" value="아이디 검색"/>
		</form> -->
		${accountList}
		<form action="service" method="get" class="center home">
			<input type="submit" value="홈으로 가기"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Nana</strong></p>
	</footer>
</body>
</html>