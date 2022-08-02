<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>CAFE NANA</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<header id="home-header">
		<h1><a href="/">CAFE<br>NANA</a></h1>
	</header>
	<div class="wrap">
		<button class="btn order"><a href="">주문하기</a></button>
		<button class="btn admin"><a href="admin/admin_service">관리자 모드</a></button>
	</div>
</body>
</html>
