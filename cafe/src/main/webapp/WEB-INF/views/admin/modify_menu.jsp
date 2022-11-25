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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/modify_menu.css"/>"/>
<script type="text/javascript" src="<c:url value='/resources/js/common/jquery.js'/>"></script>
</head>
<body>
<jsp:include page="../incl/admin_header.jsp">
		<jsp:param name="category_service" value='<%=URLEncoder.encode(\"카테고리 관리\", \"UTF-8\") %>'/>
		<jsp:param name="menu_service" value='<%=URLEncoder.encode(\"메뉴 관리\", \"UTF-8\") %>'/>
	</jsp:include>                                                                                                                                                                                      
	<div class="wrap">
		<h3>메뉴 수정</h3>
		
		<div class="menu-box">
			<div class="menu-table">
				<h4>메뉴 목록</h4>
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
							<th></th>
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
								<td><button class="m-btn" onclick="javascript:getModifyBox(${menu.mid});">수정</button></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="modify-item">
				<h4>메뉴 수정</h4>
				<div class="modify-box"></div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		// modify-box 가져오기(Ajax 활용)
		function getModifyBox(mid) {
			$.ajax({
        		async: true,
				type: 'GET',
				data: {mid},
				url: 'getModifyBox',
				dataType: 'html',
				contentType: 'application/json; charset=UTF-8',
				success: function(data) {
					$('.modify-box').html(data);
				}
        	});
		}
		
		// 중분류 가져오기
		function getCateName(value) {
			let sCateType = document.getElementById("cateType");
        	let cateType = sCateType.options[sCateType.selectedIndex].value;
        	if(cateType == "unknown") {
				return alert("대분류를 선택해주세요.");
			}
        	$.ajax({
        		async: true,
				type: 'POST',
				data: cateType,
				url: 'getCateName',
				dataType: 'html',
				contentType: 'application/json; charset=UTF-8',
				success: function(data) {
					$('#cateName').html(data);
				}
        	});
		}
	</script>
</body>
</html>