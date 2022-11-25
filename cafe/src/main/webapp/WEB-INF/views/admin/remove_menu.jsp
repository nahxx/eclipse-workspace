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
<script type="text/javascript" src="<c:url value='/resources/js/common/jquery.js'/>"></script>
</head>
<body>
<jsp:include page="../incl/admin_header.jsp">
		<jsp:param name="category_service" value='<%=URLEncoder.encode(\"카테고리 관리\", \"UTF-8\") %>'/>
		<jsp:param name="menu_service" value='<%=URLEncoder.encode(\"메뉴 관리\", \"UTF-8\") %>'/>
	</jsp:include>                                                                                                                                                                                      
	<div class="wrap">
		<h3>메뉴 삭제</h3>
		
		<c:if test="${list.size() > 0}">
			<table class="menu-table">
				<tr>
					<th></th>
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
						<td><input type="checkbox" class="check-item" id="${menu.mid}"></td>
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
		<button class="btn remove-btn" onclick="javascript:checkMsg();">삭제하기</button>
	</div>
	
	<script type="text/javascript">
		// 메뉴 삭제 확인
		function checkMsg(){
			let elems = document.querySelectorAll('.check-item');
			let check = 0;
			for(let i = 0; i < elems.length; i++) {
				if(elems[i].checked) {
					check++;
				}
			}
			if(check > 0) {
				// 메뉴가 체크되어 있을 경우
				var result = confirm("선택한 메뉴를 삭제하시겠습니까?");
				if(result) {
					// yes인 경우
					deleteMenu();
				} else {
					// no인 경우
				}
			} else {
				// 메뉴가 체크되어 있지 않을 경우
				alert("삭제할 메뉴를 선택해주세요.");
			}
		};
		
		// 메뉴 삭제
		function deleteMenu() {
			let deleteList = [];
			let elems = document.querySelectorAll('.check-item');
			for(let i = 0; i < elems.length; i++) {
    			if(elems[i].checked) {
    				deleteList.push(elems[i].id);
    			}
    		}
			// 폼생성
    		var newForm = $('<form></form>');
    		newForm.attr("type","hide");
    		newForm.attr("method","post");
    		newForm.attr("action","menuCheckDelete");
    		// 폼에 요소 추가
    		newForm.append($('<input/>', {type: 'hidden', name: 'deleteList', value: deleteList }));
    		// 폼 추가
    		newForm.appendTo('body');
    		newForm.submit();
		};
	</script>
</body>
</html>