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
		<h3>계좌 잔액 조회</h3>
		<c:if test="${selectStr.length() > 0}">
			<form action="checking_balance" method="post" class="center ch_balance">
				<label>
					<span>조회할 계좌번호</span>
					${selectStr}
				</label>
				<input type="submit" value="조회하기"/>
			</form>
		</c:if>
		
		<c:if test="${balance > -1}">
			<p class="balance_result">
				해당 계좌의 잔액은 <span class="blue">${balance}</span> 원입니다.
			</p>
			<div class="center another">
				<button class="btn" onclick="location.href='checking_balance'">다른 계좌 조회</button>
			</div>
			<div class="center" style="margin-top: 30px">
				<button class="btn" onclick="location.href='service'" style="margin-top: 30px">홈으로 가기</button>
			</div>
		</c:if>
	</div>
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>