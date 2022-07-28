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
		<h3>은행 서비스</h3>
		<div class="service-box">
			<form action="add_account" method="get" class="center">
				<input type="submit" value="신규 계좌 신청"/>
			</form>
			<form action="account_list" method="get" class="center">
				<input type="submit" value="계좌목록 확인"/>
			</form>
			<form action="transfer" method="get" class="center">
				<input type="submit" value="계좌 이체"/>
			</form>
			<form action="checking_balance" method="get" class="center">
				<input type="submit" value="잔액 조회"/>
			</form>
			<form action="checking_interest" method="get" class="center">
				<input type="submit" value="이자 지급 조회"/>
			</form>
			<form action="logout" method="get" class="center">
				<input type="submit" value="로그아웃"/>
			</form>
		</div>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>