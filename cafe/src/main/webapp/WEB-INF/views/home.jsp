<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>CAFE NANA</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<header id="home-header">
		<h1><a href="/cafe">CAFE<br>NANA</a></h1> <!-- 링크맞는지 확인하기 -->
	</header>
	<div class="wrap">
		<p>사용 모드를 선택해주세요.</p>
		<div class="admin"><a href="">고객 모드</a></div>
		<div class="admin">관리자 모드</div>
	</div>
</body>
</html>
