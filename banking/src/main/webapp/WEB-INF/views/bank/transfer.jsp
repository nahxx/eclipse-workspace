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
		<h3>계좌 이체</h3>
		<form action="transfer" method="post" class="center">
			<label>
				<span>출금할 계좌번호</span>
				${selectStr}
			</label>
			<label>
				<span>입금할 계좌번호</span>
				<input type="text" name="depositNum" value="${depositNum}">
				<c:if test="${errMsg2.length() > 0}">
					<p style="color:red">${errMsg2}</p>
				</c:if>
			</label>
			<label>
				<span>이체할 금액</span>
				<input type="text" name="amount" value="${amount}">
				<c:if test="${errMsg3.length() > 0}">
					<p style="color:red">${errMsg3}</p>
				</c:if>
			</label>
			<label>
				<span>비밀번호 입력</span>
				<input type="password" name="passwd">
				<c:if test="${errMsg4.length() > 0}">
					<p style="color:red">${errMsg4}</p>
				</c:if>
			</label>
			<input type="submit" value="이체하기"/>
		</form>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Nana</strong></p>
	</footer>
</body>
</html>