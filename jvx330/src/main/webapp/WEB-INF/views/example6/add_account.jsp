<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계좌 생성</h3>
	<form:form method="post" modelAttribute="account">
		<label>이름</label>
		<form:input path="customer.name" /><br>
		<form:radiobuttons path="accType" 
						   itemValue="typeHost"
						   itemLabel="typeCode"
						   items="${accountTypeList}"/><br>
		<label>초기 입금액</label>
		<form:input path="initAmount"/>
		<input type="submit" value="생성하기" />
	</form:form>
</body>
</html>