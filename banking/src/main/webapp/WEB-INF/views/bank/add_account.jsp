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
		<h3>신규 계좌 신청</h3>
		<form action="add_account" method="post" class="center">
			<label>
				<span>계좌 타입</span>
				<input type="radio" name="accType" value="SavingsAccount" checked>SavingsAccount
				<input type="radio" name="accType" value="CheckingAccount">CheckingAccount
			</label>
			<label>
				<span>사용자 아이디</span>
				<input class="readonly" type="text" name="userId" value="${userId}" readonly>
			</label>
			<label>
				<span>초기 입금액</span>
				<input type="text" name="initBalance">
				<c:if test="${errMsg1.length() > 0}">
					<p style="color:red">${errMsg1}</p>
				</c:if>
			</label>
			<input type="submit" value="신규 계좌 신청"/>
		</form>
	</div>
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>