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
		<h3>이체 결과</h3>
		<table class="transfer_result">
			<tr>
				<th>출금 계좌</th>
				<td>${transferCommand.withdrawNum}</td>
			</tr>
			<tr>
				<th>입금 계좌</th>
				<td>${transferCommand.depositNum}</td>
			</tr>
			<tr>
				<th>출금 금액</th>
				<td>${transferCommand.amount.intValue()} 원</td>
			</tr>
			<tr>
				<th>출금 전 잔액</th>
				<td>${before} 원</td>
			</tr>
			<tr>
				<th>출금 후 잔액</th>
				<td class="blue">${after} 원</td>
			</tr>
		</table>
		<form action="service" method="get" class="center home">
			<input type="submit" value="홈으로 가기"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>