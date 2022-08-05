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
						<a href="${category.cid}">
							${category.cateType}
						</a>
					</div>
				</c:forEach>
			</div>
			<!-- 메뉴리스트 영역 -->
			<h3>메뉴를 선택해주세요.</h3>
			<div class="menu-box">
				<c:forEach var="menu" items="${list}">
					<div class="menu-item" onclick="javascript:sendPost('<c:url value="/order/select_menu"/>', ${menu.mid}, ${cid});" >
						<img alt="${menu.name}" src="<c:url value="/resources/images/${menu.imageUrl}"/>"/>
						<p><span>${menu.name}</span><br>${menu.price.intValue()}원</p>
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

		<!-- 장바구니/ 주문확인 영역 -->
		<div class="cart-wrap">
			<!-- 장바구니 영역 -->
			<div class="cart-box">
				<h5>주문 목록</h5>
				<table>
					<tr>
						<th>메뉴</th>
						<th>수량</th>
						<th>금액</th>
						<th>비고</th>
					</tr>
					<c:forEach var="list" items="${cart.cartList}">
						<tr>
							<td>${list.menuItem.name}(${list.hotOrIce})</td>
							<td>
								<c:if test="${list.amount < 2}">
									<button class="mop disabled" onclick="location.href='<c:url value="/order/count_amount/${list.menuItem.name}/${list.hotOrIce}/0"/>'">-</button>
								</c:if>
								<c:if test="${list.amount > 1}">
									<button class="mop" onclick="location.href='<c:url value="/order/count_amount/${list.menuItem.name}/${list.hotOrIce}/0"/>'">-</button>
								</c:if>
								${list.amount}
								<button  class="mop" onclick="location.href='<c:url value="/order/count_amount/${list.menuItem.name}/${list.hotOrIce}/1"/>'">+</button>
							</td>
							<td>${list.sumPrice.intValue()}</td>
							<td><button class="remove" onclick="location.href='<c:url value="/order/remove_item/${list.menuItem.name}/${list.hotOrIce}"/>'">삭제</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- 주문확인 영역 -->
			<div class="order-box">
				<div class="total-amount">
					<p>선택된 상품</p>
					<p><span>${totalAmount}</span>개</p>
				</div>
				<div class="all-remove">
					<div><a href="<c:url value="/order/all_remove/${cid}"/>">주문 취소</a></div>
				</div>
				<div class="total-price">
					<p>주문 금액</p>
					<p><span>${cart.totalPrice.intValue()}</span>원</p>
				</div>
				<div class="finally-order">
					<div><a href="<c:url value="/order/finally-order/${cid}"/>">주문<br>하기</a></div>
				</div>
			</div>
		</div>

		<!-- 메뉴 담기 선택창 영역 -->
		<c:if test="${not empty menuItem}">
			<div class="select-option">
				<button class="btn-close" type="button"></button>
				<img alt="${menuItem.name}" src="<c:url value="/resources/images/${menuItem.imageUrl}"/>"/>
				<p>
					<strong>${menuItem.name}</strong><br>
					${menuItem.price.intValue()}원
				</p>
				<form action="<c:url value="/order/add_cart"/>" method="post">
					<c:if test="${cid eq 1005}">
						<label class="radio on"><input type="radio" name="hotOrIce" value="ICE" checked />ICE</label>
					</c:if>
					<c:if test="${cid ne 1005}">
						<label class="radio on"><input type="radio" name="hotOrIce" value="HOT" checked />HOT</label>
						<label class="radio"><input type="radio" name="hotOrIce" value="ICE" />ICE</label>
					</c:if>
					<label class="amount"><span>수량</span><input type="text" name="amount" value="1"/>&nbsp;개</label>
					<input type="submit" value="담기"/>
				</form>
			</div>
		</c:if>
		
		<!-- 주문 완료창 영역 -->
		<c:if test="${oid ne null}">
			<div class="order-list">
				<p>주문이 완료되었습니다.</p>
				<p>주문번호&nbsp;<span>${oid}</span></p>
				<button class="btn" onclick="location.href='<c:url value='/'/>'">홈으로 가기</button>
			</div>
		</c:if>
	</div>

	<script>
		$(function() {
			// 카테고리 선택 css 적용
			$('.cate-box').each(function() {
				if($(this).hasClass("${cid}")) {
					$(this).addClass("on");
				}else {
					$(this).removeClass("on");
				}
			});
			
			// 옵션 선택 css 적용
			$('.radio').click(function() {
	    		  $('input[type=radio]').removeAttr("checked");
	    		  $(this).find('input[type=radio]').attr("checked", "checked");
	    		  $('.radio').removeClass("on");
	    		  $(this).addClass("on");
			});
			
			// 옵션 창 닫기 css 적용
			$('.btn-close').click(function() {
	    		$('.select-option').css("display", "none");
	    	});
		});
		
		// 폼 생성 후 컨트롤러로 넘어가기
		function sendPost(url, mid, cid) {
			// 폼 생성
			console.log(url);
			let form = document.createElement('form');
			form.setAttribute('method', 'post');
			form.setAttribute('action', url);
			document.charset = "UTF-8";
			
			// input1 추가
			let hiddenField1 = document.createElement("input");
			hiddenField1.setAttribute('type', 'hidden');
			hiddenField1.setAttribute('name', 'mid');
			hiddenField1.setAttribute('value', mid);
			form.appendChild(hiddenField1);
			
			// input2 추가
			let hiddenField2 = document.createElement("input");
			hiddenField2.setAttribute('type', 'hidden');
			hiddenField2.setAttribute('name', 'cid');
			hiddenField2.setAttribute('value', cid);
			form.appendChild(hiddenField2);
			
			document.body.appendChild(form);
			form.submit();
		}
	</script>

</body>
</html>
