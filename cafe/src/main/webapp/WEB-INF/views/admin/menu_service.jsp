<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>CAFE NANA</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<header id="header">
		<jsp:include page="../incl/admin_header.jsp">
			<jsp:param name="category_service" value='<%=URLEncoder.encode(\"카테고리 관리\", \"UTF-8\") %>'/>
			<jsp:param name="menu_service" value='<%=URLEncoder.encode(\"메뉴 관리\", \"UTF-8\") %>'/>
		</jsp:include>
	</header>
	<div class="wrap">
		<h3>메뉴 관리</h3>
		<div class="service-box admin-box">
			<button class="btn admin-btn" onclick="location.href='add_menu'">메뉴 추가</button>
			<button class="btn admin-btn" onclick="location.href='remove_menu'">메뉴 삭제</button>
			<button class="btn admin-btn" onclick="location.href='modify_menu'">메뉴 수정</button>
		</div>
	</div>
</body>
</html>