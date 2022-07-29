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
		<h3><span>${name}</span> 님의 계좌목록</h3>
		<!-- <form action="account_list" method="post" class="center">
			<label>
				<span>찾을 사용자 아이디</span>
				<input type="text" name="userId"/>
			</label><br>
			<input type="submit" value="아이디 검색"/>
		</form> -->
		${accountList}
		<div class="center suc">
			<button class="btn" onclick="location.href='service'">홈으로 가기</button>
		</div>
	</div>
	<%@ include file="../incl/footer.jsp" %>
</body>
</html>