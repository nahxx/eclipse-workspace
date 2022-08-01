<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계좌가 생성되었습니다.</h3>
	<label>이름</label> : ${account.customer.name}<br>
	<label>계좌타입</label> : ${account.accType}<br>
	<label>초기입금액</label> : ${account.initAmount}<br>
</body>
</html>