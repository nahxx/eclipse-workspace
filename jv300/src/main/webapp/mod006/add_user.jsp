<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	label {
		display: block;
	}
	h3 {
		text-align: center;
		margin-bottom: 20px;
	}
	.wrap {
		width: 100%;
		height: 100%;
		background: khaki;
	}
	.signUp {
		width: 1280px;
		height: auto;
		margin: 0 auto;
		overflow: hidden;
	}
	ul, li {
		list-style: none;
	}
	li {
		margin-bottom: 50px;
		height: 30px;
	}
	label {
		width: 100px;
	}
	input[type="text"], input[type="password"] {
		width: 200px;
		height: 30px;
	}
	input[type="submit"] {
		float: right;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h3>회원가입</h3>
		<form class="signUp" action="add_user.do" method="post">
			<ul>
				<li>
					<label for="userId">회원아이디 :
						<input type="text" id="userId" name="userId">
					</label>
				</li>
				<li>
					<label for="passwd">비밀번호 :
						<input type="password" id="passwd" name="passwd">
					</label>
				</li>
				<li>
					<label for="userName">이름 : 
						<input type="text" id="userName" name="userName">
					</label>
				</li>
				<li>
					<label for="ssn">주민번호 : 
						<input type="text" id="ssn" name="ssn">
					</label>
				</li>
				<li>
					<label for="email">이메일 : 
						<input type="text" id="email" name="email1"> @ 
						<select name="email2">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="kakao.com">kakao.com</option>
							<option value="daum.net">daum.net</option>
							<!-- <option value="naver">직접입력</option> -->
						</select>
					</label>
				</li>
				<li>
					<label for="addr1">주소1 : 
						<input type="text" id="addr1" name="addr1">
					</label>
					<label for="addr1">주소2 : 
						<input type="text" id="addr2" name="addr2">
					</label>
				</li>
			</ul>
			<input type="submit" value="확인"/>
		</form>
	</div>
</body>
</html>
</body>
</html>