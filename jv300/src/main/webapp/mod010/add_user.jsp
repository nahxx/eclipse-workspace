<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	.signUp {
		width: 500px;
		height: auto;
		margin: 0 auto;
		padding: 20px 20px;
		box-sizing: border-box;
	}
	ul, li {
		list-style: none;
	}
	ul {
		margin: 0 auto;
		height: 100%;
	}
	li {
		margin-bottom: 30px;
	}
	label {
		display: block;
		
	}
	span {
		width: 100px;
		display: inline-block;
	}
	input[type="text"], input[type="password"] {
		width: 250px;
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
	}
	input[type="submit"]:hover {
		background: white;
		border: 1px solid gray;
		color: gray;
		transition: .3s;
	}
	.center {
		display: block;
		width: 500px;
		margin-top: 40px;
		text-align: center;
	}
	.email2 {
		margin-left: 105px;
		margin-top: 10px;
		width: 258px;
		height: 35px;
	}
	.addr2 {
		margin-top: 10px;
		
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
			<h4>회원가입</h4>
			<form class="signUp" action="add_user.do" method="post">
				<ul>
					<li>
						<label for="userId"><span>회원아이디</span>
							<input type="text" id="userId" name="userId">
						</label>
					</li>
					<li>
						<label for="passwd"><span>비밀번호</span>
							<input type="password" id="passwd" name="passwd">
						</label>
					</li>
					<li>
						<label for="userName"><span>이름</span>
							<input type="text" id="userName" name="userName">
						</label>
					</li>
					<li>
						<label for="ssn"><span>주민번호</span>
							<input type="text" id="ssn" name="ssn">
						</label>
					</li>
					<li>
						<label for="email"><span>이메일</span>
							<input type="text" id="email" name="email1"> @ 
							<select name="email2" class="email2">
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="kakao.com">kakao.com</option>
								<option value="daum.net">daum.net</option>
								<!-- <option value="naver">직접입력</option> -->
							</select>
						</label>
					</li>
					<li>
						<label for="addr1"><span>주소</span>
							<input type="text" id="addr1" name="addr1">
						</label>
						<label for="addr2" class="addr2"><span>상세주소</span>
							<input type="text" id="addr2" name="addr2">
						</label>
					</li>
				</ul>
				<div class="center"><input type="submit" name="submit" value="가입하기"/></div>
			</form>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>
</body>
</html>