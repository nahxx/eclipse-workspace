<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<ul class="gnb">
	<li><a href="add_account"><%=URLDecoder.decode(request.getParameter("add_account"), "UTF-8") %></a></li>
	<li><a href="account_list"><%=URLDecoder.decode(request.getParameter("account_list"), "UTF-8") %></a></li>
	<li><a href="transfer"><%=URLDecoder.decode(request.getParameter("transfer"), "UTF-8") %></a></li>
	<li><a href="checking_balance"><%=URLDecoder.decode(request.getParameter("getBalance"), "UTF-8") %></a></li>
	<li><a href="checking_interest"><%=URLDecoder.decode(request.getParameter("getInterest"), "UTF-8") %></a></li>
	<li><a href="logout"><%=URLDecoder.decode(request.getParameter("logout"), "UTF-8") %></a></li>
</ul>