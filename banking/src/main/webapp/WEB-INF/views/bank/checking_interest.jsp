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
		<h3>이자 지급 조회</h3>
		<c:if test="${selectStr.length() > 0}">
			<form action="checking_interest" method="post" class="center">
				<label>
					<span>조회할 계좌번호</span>
					${selectStr}
				</label>
				<input type="submit" value="조회하기"/>
			</form>
		</c:if>
		
		<%-- <c:if test="${balance > 0}">
			해당 계좌의 잔액은 <span>${balance}</span> 원입니다.
		</c:if> --%>
	</div>
	<footer>
		<p>Copyright &copy; made by <strong>Kim Nahye</strong></p>
	</footer>
</body>
</html>