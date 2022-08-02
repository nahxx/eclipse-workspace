<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<header class="header">
	<h1><a href="/">CAFE NANA</a></h1> <!-- 링크 확인할것 -->
	<ul class="gnb">
		<li><a href="category_service"><%=URLDecoder.decode(request.getParameter("category_service"), "UTF-8") %></a></li>
		<li><a href="menu_service"><%=URLDecoder.decode(request.getParameter("menu_service"), "UTF-8") %></a></li>
	</ul>
</header>