<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
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
		<div class="center suc">
			<button class="btn" onclick="location.href='service'">홈으로 가기</button>
		</div>
	</div>
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>