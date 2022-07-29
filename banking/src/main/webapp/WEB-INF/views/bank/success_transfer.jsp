<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
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
		<jsp:include page="../incl/header.jsp">
			<jsp:param name="title" value='<%=URLEncoder.encode(\"나나은행\", \"UTF-8\") %>'/>
		</jsp:include>
		<jsp:include page="../incl/gnb.jsp">
			<jsp:param name="add_account" value='<%=URLEncoder.encode(\"계좌생성\", \"UTF-8\") %>'/>
			<jsp:param name="account_list" value='<%=URLEncoder.encode(\"계좌목록\", \"UTF-8\") %>'/>
			<jsp:param name="transfer" value='<%=URLEncoder.encode(\"계좌이체\", \"UTF-8\") %>'/>
			<jsp:param name="getBalance" value='<%=URLEncoder.encode(\"잔액조회\", \"UTF-8\") %>'/>
			<jsp:param name="getInterest" value='<%=URLEncoder.encode(\"이자조회\", \"UTF-8\") %>'/>
			<jsp:param name="logout" value='<%=URLEncoder.encode(\"로그아웃\", \"UTF-8\") %>'/>
		</jsp:include>
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
		<div class="center suc">
			<button class="btn" onclick="location.href='service'">홈으로 가기</button>
		</div>
	</div>
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>