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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/order.css"/>"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../incl/order_header.jsp"/>
	<div class="wrap">
		<!-- 메뉴선택 영역 -->
		<div class="menu-wrap">
			<!-- 카테고리 선택 영역 -->
			<div class="category-wrap">
				<c:forEach var="category" items="${cateList}">
					<div class="cate-box ${category.cid}">
						<a href="older/order_service/${category.cateType}">
							${category.cateType}
						</a>
					</div>
				</c:forEach>
			</div>
			<!-- 메뉴리스트 영역 -->
			<h3>메뉴를 선택해주세요.</h3>
			<div class="menu-box">
				<c:forEach var="menu" items="${list}">
					<div class="menu-item">
						<img alt="${menu.name}" src="<c:url value="/resources/images/${menu.imageUrl}"/>"/>
						<p><span>${menu.name}</span><br>${menu.price}</p>
					</div>
				</c:forEach>
				<c:if test="${size % 4 < 4}">
					<c:forEach var="i" begin="1" end="${4 - (size % 4)}">
						<div class="menu-item null">
							준비중:)
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>

		<!-- 장바구니/ 결제 부분 -->
		<div class="cart-wrap">
			장바구니/결제
		</div>
	</div>
	<!--
	<script>
		$(function) {
			$('.cate-box').click(function() {
				$('.cate-box').removeClass("on");
				$(this).addClass("on");
			});
		}
	</script>
	-->
</body>
</html>
