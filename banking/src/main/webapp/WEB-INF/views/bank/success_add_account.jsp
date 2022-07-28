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
		<h3>신규계좌 신청 성공</h3>
		<table class="transfer_result">
			<tr>
				<th>사용자아이디</th>
				<td>${customer.userId}</td>
			</tr>
			<tr>
				<th>계좌 타입</th>
				<c:if test="${accType eq 'S'}">
					<td>SavingsAccount</td>
				</c:if>
				<c:if test="${accType eq 'C'}">
					<td>CheckingAccount</td>
				</c:if>
			</tr>
			<tr>
				<th>계좌 번호</th>
				<td>${account.accountNum}</td>
			</tr>
			<tr>
				<th>계좌 잔액</th>
				<td>${account.balance.intValue()} 원</td>
			</tr>
			<c:if test="${accType eq 'S'}">
				<tr>
					<th>이자율</th>
					<td class="blue">${account.interestRate}</td>
				</tr>
			</c:if>
			<c:if test="${accType eq 'C'}">
				<tr>
					<th>마이너스 한도</th>
					<td>${account.overdraftAmount.intValue()}</td>
				</tr>
			</c:if>
		</table>
		<form action="service" method="get" class="center suc">
			<input type="submit" value="홈으로 가기"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>