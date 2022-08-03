<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="order-header">
	<h1><a href="<c:url value='/'/>">CAFE<br>NANA</a></h1>
	<%-- <ul class="gnb">
		<li><a href="category_service"><%=URLDecoder.decode(request.getParameter("category_service"), "UTF-8") %></a></li>
		<li><a href="menu_service"><%=URLDecoder.decode(request.getParameter("menu_service"), "UTF-8") %></a></li>
	</ul> --%>
</header>