<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul, li {
		
	}
	.tab {
		margin-left: 50px;
	}
</style>
</head>
<body>
	<form action="list_course_contents.do" method="get">
		<ul>

				<c:forEach var="testList" items="${testList}">
					<li>
					${testList}
					</li>
				</c:forEach>

		</ul>
		<input type="submit" value="확인">
	</form>
</body>
</html>