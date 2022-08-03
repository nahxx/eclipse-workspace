<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>CAFE NANA</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css"/>"/>
</head>
<body>
	<jsp:include page="../incl/admin_header.jsp">
		<jsp:param name="category_service" value='<%=URLEncoder.encode(\"카테고리 관리\", \"UTF-8\") %>'/>
		<jsp:param name="menu_service" value='<%=URLEncoder.encode(\"메뉴 관리\", \"UTF-8\") %>'/>
	</jsp:include>                                                                                                                                                                                      
	<div class="wrap">
		<h3>카테고리 추가</h3>
		<form:form class="add-cate" method="post" modelAttribute="category">
			<label>
				<span>대분류</span>
				<form:input path="cateType" />
			</label>
			<label>
				<span>중분류</span>
				<form:input path="cateName" />
			</label>
			<input type="submit" value="추가하기" />
		</form:form>
		
		<c:if test="${list.size() > 0}">
			<table class="cate-table">
				<tr>
					<th>No.</th>
					<th>대분류</th>
					<th>중분류</th>
					<th>등록시간</th>
				</tr>
				<c:forEach var="cate" items="${list}">
					<tr>
						<td>${cate.cid}</td>
						<td>${cate.cateType}</td>
						<td>${cate.cateName}</td>
						<td>${cate.regDate }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>