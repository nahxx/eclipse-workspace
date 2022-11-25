<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<form class="modify-menu" action="modify_menu" method="post" enctype="multipart/form-data">
			<label>
				<span>대분류</span>
				<select id="cateType" name="cateType" onChange='javascript:getCateName(this);'>
					<option disabled="disabled" selected="selected" value="unknown">-- 선택 --</option>
					<c:forEach var="cate" items="${cateList}">
						<option value="${cate.cateType}">${cate.cateType}</option>
					</c:forEach>
				</select>
			</label>
			<label>
				<span>중분류</span>
				<select id="cateName" name="cateName">
				</select>
			</label>
			<label>
				<span>메뉴명</span>
				<input type="text" name="name" value="${menu.getName()}"/>
			</label>
			<label>
				<span>금액</span>
				<input type="text" name="price" value="${menu.getPrice()}"/>
			</label>
			<label>
				<span>이미지</span>
				<input type="file" name="imageFile"/>
			</label>
			<input type="submit" value="수정하기" />
		</form>
</html>