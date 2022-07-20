<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap {
		width: 100%;
		height: 100%;
	}
	h3, h5 {
		text-align: center;
	}
	#header {
		text-align: center;
		height: 50px;
		line-height: 50px;
	}
	#content-wrapper {
		margin: 150px 0;
	}
	ul, li {
		list-style: none;
	}
	ul {
		margin: 0 auto;
		height: 100%;
	}
	li {
		text-align: center;
	}
	#footer
	{
		text-align: center;
		color: gray;
		height: 80px;
		line-height: 80px;
		border-top: 1px solid #888;
		background: rgba(0, 0, 0, 0.05);
	}
</style>
</head>
<body>
	<div class="wrap">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod007 : 자바빈즈\", \"UTF-8\") %>" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<h3>가입 실패</h3>
<%--
	방법1 : 내가 한거
				<h5>
				<jsp:useBean id="errorMsgs" class="java.util.ArrayList" scope="request"/>
				<%
					for(String str : (ArrayList<String>)errorMsgs) {
				%>
						<%=str %><br>
				<%
					}
				%>
				</h5>
--%>
			<ul>
<%--
	방법2 : 선생님
			<%
				@SuppressWarnings("unchecked")
				List<String> errorMsgs = (List<String>)request.getAttribute("errorMsgs");
				for(String errorMsg : errorMsgs) {
			%>
				<li><%=errorMsg %></li>
			<%		
				}
			%>
--%>
				<!-- 방법 3 -->
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>