<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<link rel="stylesheet" href="../css/fixmethod.css">
<link rel="stylesheet" href="../css/style.css">
<style>
	.container {
      padding-top: 80px;
      display: flex;
      flex-wrap: wrap;
      height: 100%;
      width: 700px;
      margin: 0 auto;
    }
    .content {
      height: 50px;
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 30px;
    }
    .content > input {
      height: 35px;
      line-height: 35px;
      padding-left: 5px;
      width: 60%;
      height: 50px;
      font-size: 15px;
    }
    .i-btn {
      display: flex;
      justify-content: center;
      margin-top: 30px;
      height: 50px;
    }
    .i-btn > input {
      justify-content: center;
      border-style: none;
      font-size: 20px;
      background: #324ff4;
      color: white;
      border-radius: 30px;
      width: 150px;
      height: 50px;
      cursor: pointer;
    }
    .sign-in {
    	margin-left : 20px;
    }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="/incl/menu.jsp" %>
	</div>
	<h3 class="title">회원가입</h3>
	<div class="container">
		<form action="login" method="post">
      <div class="content">
        <input type="text" name="userId" placeholder="아이디"/><br>
      </div>
      <div class="content">
        <input type="password" name="passwd" placeholder="비밀번호"/><br>
      </div>
      <div class="i-btn">
        <input type="submit" value="로그인" class="in-btn"/>
        <input type="submit" value="회원가입" class="sign-in"/>
      </div>
		</form>
	</div>
</body>
</html>