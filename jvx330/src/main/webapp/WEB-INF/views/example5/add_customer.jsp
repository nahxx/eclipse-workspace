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
	<h3>회원가입</h3>
	<form:form method="post" modelAttribute="customer">
	<!-- modelAttribute는 커멘드지정(customer는 CustomerCommand를 가리킴/ 입력안하면 기본값 Command)-->
		<label>e-mail</label>
		<form:input path="email1" />@
		<form:select path="email2">
			<option value="unknown">---선택---</option>
			<form:options itemValue="emailHost"
						  itemLabel="emailCode"
						  items="${emailProviderList}" />
		</form:select><br>
		<label>비밀번호</label>
		<form:password path="passwd" /><br>
		<label>이름</label>
		<form:input path="name" /><br>
		<label>주민번호</label>
		<form:input path="ssn" /><br>
		<label>연락처</label>
		<form:select path="phone1">
			<option value="unknown">---선택---</option>
			<form:options	items="${phoneProviderList}"/>
		</form:select>-
		<form:input path="phone2" />
		<input type="submit" value="가입하기" />
	</form:form>
</body>
</html>