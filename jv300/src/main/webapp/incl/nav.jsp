<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<ul id="nav">
	<li><a href="/jv300/mod010/list_user.do"><%=URLDecoder.decode(request.getParameter("gnb1"), "UTF-8") %></a></li>
	<li><a href="/jv300/mod010/update_user.jsp"><%=URLDecoder.decode(request.getParameter("gnb2"), "UTF-8") %></a></li>
	<li><a href="/jv300/mod011/login"><%=URLDecoder.decode(request.getParameter("gnb3"), "UTF-8") %></a></li>
</ul>