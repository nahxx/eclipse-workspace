<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<h1><a href="service"><%=URLDecoder.decode(request.getParameter("title"), "UTF-8") %></a></h1>