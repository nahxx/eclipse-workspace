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
		<h3>신규 계좌 신청</h3>
		<form action="add_account" method="post" class="center">
			<label>
				<span>계좌 타입</span>
				<input type="radio" name="accType" value="SavingsAccount" checked>SavingsAccount
				<input type="radio" name="accType" value="CheckingAccount">CheckingAccount
			</label>
			<label>
				<span>사용자 아이디</span>
				<input class="userId" type="text" name="userId" value="${userId}" readonly>
			</label>
			<input type="submit" value="신규 계좌 신청"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Nana</strong></p>
	</footer>
</body>
</html>