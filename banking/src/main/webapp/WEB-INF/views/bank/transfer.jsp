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
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>