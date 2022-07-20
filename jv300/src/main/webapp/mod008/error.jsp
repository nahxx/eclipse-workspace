<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입실패</title>
<style>
	html, body {
		margin: 0;
		padding: 0;
	}
	.wrap {
		width: 100%;
		height: 100vh;
	}
	h3 {
		line-height: 80px;
		text-align: center;
		margin: 0;
	}
	#header {
		height: 80px;
		line-height: 50px;
	}
	#content-wrapper {
		width: 100%;
		height: calc(100vh - 161px);
		padding-top: 200px;
		box-sizing: border-box;
	}
	ul, li {
		list-style: none;
	}
	ul {
		margin: 0 auto;
		padding: 0;
	}
	li {
		text-align: center;
		margin-top: 30px;
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
				<jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod008 : 자바빈즈\", \"UTF-8\") %>" />
			</jsp:include>
		</div>
		<div id="content-wrapper">
			<c:if test="${not empty errorMsgs}"> <%-- errorMsgs가 비어있지 않다면 --%>
				<h3>다음과 같은 이유로 가입되지 않았습니다.</h3>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li>${message}</li>
					</c:forEach>
					<%-- if else 사용하는 법 --%>
					<c:choose></c:choose>
					<c:otherwise></c:otherwise>
				</ul>
			</c:if>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %>
		</div>
	</div>
</body>
</html>