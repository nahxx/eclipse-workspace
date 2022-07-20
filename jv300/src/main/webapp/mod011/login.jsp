<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
		padding-top: 120px;
		box-sizing: border-box;
	}
	.login {
		width: 500px;
		height: auto;
		margin: 0 auto;
		padding: 20px 20px;
		box-sizing: border-box;
	}
	label {
		display: block;
		text-align: center;
	}
	label + label {
		margin-top: 20px;
	}
	span {
		display: inline-block;
		width: 100px;
		text-align: left;
	}
	input[type="text"], input[type="password"] {
		width: 200px;
		height: 30px;
		border: 1px solid gray;
	}
	input[type="submit"] {
		width: 250px;
		height: 50px;
		background: gray;
		color: white;
		font-size: 18px;
		border: none;
		border-radius: 25px;
		cursor: pointer;
		display: block;
		margin: 0 auto;
		margin-top: 40px;
		text-align: center;
	}
	input[type="submit"]:hover {
		background: white;
		border: 1px solid gray;
		color: gray;
		transition: .3s;
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
			<h4>로그인</h4>
			<form action="login" method="post" class="login">
				<label><span>아이디</span>
					<input type="text" name="userId"/>
				</label>
				<label><span>비밀번호</span>
					<input type="password" name="passwd"/>
				</label>
				<input type="submit" value="로그인"/>
			</form>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>