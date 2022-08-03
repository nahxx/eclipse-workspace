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
		<h3>메뉴 추가</h3>
		<form class="add-menu" action="add_menu" method="post" enctype="multipart/form-data">
			<label>
				<span>대분류</span>
				<select name="cateType">
					<c:forEach var="cate" items="${cateList}">
						<option value="${cate.cateType}">${cate.cateType}</option>
					</c:forEach>
				</select>
			</label>
			<label>
				<span>중분류</span>
				<select name="cateName">
					<c:forEach var="cate" items="${cateList}">
						<option value="${cate.cateName}">${cate.cateName}</option>
					</c:forEach>
				</select>
			</label>
			<label>
				<span>메뉴명</span>
				<input type="text" name="name"/>
			</label>
			<label>
				<span>금액</span>
				<input type="text" name="price"/>
			</label>
			<label>
				<span>이미지</span>
				<input type="file" name="imageFile"/>
			</label>
			<input type="submit" value="추가하기" />
		</form>
		
		<c:if test="${list.size() > 0}">
			<table class="menu-table">
				<tr>
					<th>No.</th>
					<th>대분류</th>
					<th>중분류</th>
					<th>이름</th>
					<th>금액</th>
					<th>이미지</th>
					<th>등록시간</th>
				</tr>
				<c:forEach var="menu" items="${list}">
					<tr>
						<td>${menu.mid}</td>
						<td>${menu.menuCategory.cateType}</td>
						<td>${menu.menuCategory.cateName}</td>
						<td>${menu.name}</td>
						<td>${menu.price}</td>
						<td><img style="width:100px" alt="${menu.name}" src="<c:url value="/resources/images/${menu.imageUrl}"/>"></td>
						<td>${menu.regDate}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>