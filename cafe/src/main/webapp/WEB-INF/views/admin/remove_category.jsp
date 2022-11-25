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
		<h3>카테고리 삭제</h3>
		
		<c:if test="${list.size() > 0}">
			<table class="cate-table">
				<tr>
					<th></th>
					<th>No.</th>
					<th>대분류</th>
					<th>중분류</th>
					<th>등록시간</th>
				</tr>
				<c:forEach var="cate" items="${list}">
					<tr>
						<td><input type="checkbox" class="check-item" id="${cate.cid}"></td>
						<td>${cate.cid}</td>
						<td>${cate.cateType}</td>
						<td>${cate.cateName}</td>
						<td>${cate.regDate }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<button class="btn" onclick="javascript:checkMsg();">삭제하기</button>
	</div>
	
	<script type="text/javascript">
		// 삭제 확인
		function checkMsg(){
			let elems = document.querySelectorAll('.check-item');
			let check = 0;
			for(let i = 0; i < elems.length; i++) {
    			if(elems[i].checked) {
    				check++;
    			}
    		}
			if(check > 0) {
				// 카테고리가 체크되어 있을 경우
				var result = confirm("해당 카테고리의 메뉴도 함께 삭제됩니다.\n선택한 카테고리를 삭제하시겠습니까?");
				if(result) {
					// yes인 경우
					deleteCate();
				} else {
					// no인 경우
				}
			} else {
				// 카테고리가 체크되어 있지 않을 경우
				alert("삭제할 카테고리를 선택해주세요.");
			}
		};
		
		// 삭제
		function deleteCate() {
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
    		newForm.attr("action","cateCheckDelete");
    		// 폼에 요소 추가
    		newForm.append($('<input/>', {type: 'hidden', name: 'deleteList', value: deleteList }));
    		// 폼 추가
    		newForm.appendTo('body');
    		newForm.submit();
		};
	</script>
</body>
</html>