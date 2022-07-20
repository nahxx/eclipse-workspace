<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body {
		margin: 0;
		padding: 0;
	}
	.wrap {
		width: 100%;
		height: 100vh;
	}
	a {
		text-decoration: none;
		color: black;
	}
	#header {
		height: 80px;
		line-height: 50px;
	}
	#header #nav {
		float: right;
		margin-top: -65px;
		margin-right: 20px;
		overflow: hidden;
	}
	#header #nav li {
		list-style: none;
		float: left;
	}
	#header #nav li + li {
		margin-left: 20px;
	}
	h3, h4 {
		line-height: 80px;
		text-align: center;
		margin: 0;
	}
	h4 {
		padding-top: 80px;
	}
	#content-wrapper {
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.02);
		height: calc(100vh - 161px);
	}
	table {
		margin: 0 auto;
		width: 800px; 
		border: 1px solid lightgray; 
		border-collapse: collapse;
	} 
	th, td {
		height: 30px;  
		border: 1px solid lightgray; 
		text-align: center;
	} 
	.user-list th {
		width: 15%; 
		background: gray;
		color: white;
	} 
	#footer {
		text-align: center;
		color: gray;
		height: 80px;
		line-height: 80px;
		border-top: 1px solid #888;
		background: rgba(0, 0, 0, 0.05);
	}
</style>
</head>
<body>
	<div class="wrap">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod010 : 자바빈즈\", \"UTF-8\") %>'/>
			</jsp:include>
			<jsp:include page="/incl/nav.jsp">
				<jsp:param name="gnb1" value='<%=URLEncoder.encode(\"회원정보\", \"UTF-8\") %>'/>
				<jsp:param name="gnb2" value='<%=URLEncoder.encode(\"회원정보수정\", \"UTF-8\") %>'/>
				<jsp:param name="gnb3" value='<%=URLEncoder.encode(\"로그인\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h4>회원정보</h4>
			<Table class="user-list">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>주민번호</th>
					<th>이메일</th>
					<th>주소</th>
				</tr>
				<c:forEach var="user" items="${list}">
					<tr>
						${user}
					</tr>
				</c:forEach>
			</Table>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>