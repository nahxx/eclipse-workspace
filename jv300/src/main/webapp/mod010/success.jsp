<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입완료</title>
<style>
	html, body {
		margin: 0;
		padding: 0;
	}
	.wrap {
		width: 100%;
		height: 100%;
	}
	h1, h3, h4 {
		text-align: center;
	}
	h3 {
		line-height: 80px;
		margin: 0;
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
	#content-wrapper {
		width: 100%;
		height: calc(100vh - 161px);
		padding-top: 200px;
		box-sizing: border-box;
	}
	h4 {
		margin-top: 40px;
	}
	table {
		margin: 0 auto;
		width: 500px; 
		border: 1px solid lightgray; 
		border-collapse: collapse;
	} 
	th, td {
		height: 30px;
		border: 1px solid lightgray; 
		text-align: left;
	} 
	th {
		width: 20%; 
		background: gray;
		color: white;
	} 
	span {
		color: #666;
		margin-right: 5px;
	}
	#footer
	{
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
				<jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod008 : 자바빈즈\", \"UTF-8\") %>" />
			</jsp:include>
			<jsp:include page="/incl/nav.jsp">
				<jsp:param name="gnb1" value='<%=URLEncoder.encode(\"회원정보\", \"UTF-8\") %>'/>
				<jsp:param name="gnb2" value='<%=URLEncoder.encode(\"회원정보수정\", \"UTF-8\") %>'/>
				<jsp:param name="gnb3" value='<%=URLEncoder.encode(\"로그인\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">

				<h3><span>${user.userName}</span>님 가입을 축하드립니다.</h3>
				<h4>가입 정보</h4>
				<table>
					<tr><th>회원아이디</th><td>${user.userId}<br></td></tr>
					<tr><th>비밀번호</th><td>${user.passwd}</td></tr>
					<tr><th>이름</th><td>${user.userName}</td></tr>
					<tr><th>주민번호</th><td>${user.ssn}</td></tr>
					<tr><th>이메일</th><td>${user.email}</td></tr>
					<tr><th>주소</th><td>${user.addr}</td></tr>
				</table>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>