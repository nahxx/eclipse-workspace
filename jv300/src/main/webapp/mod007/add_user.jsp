<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	#header {
		height: 50px;
		line-height: 50px;
	}
	h3 {
		text-align: center;
		margin-bottom: 20px;
	}
	.wrap {
		width: 100%;
		height: 100%;
	}
	#content-wrapper {
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.02);
	}
	.signUp {
		width: 500px;
		height: auto;
		margin: 0 auto;

		padding: 30px 20px;
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
				<jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 자바빈즈\", \"UTF-8\") %>'/>
			</jsp:include>
		</div>
		<div id="content-wrapper">
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
				<div class="center"><input type="submit" value="확인"/></div>
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