<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productUpdate.jsp</title>
</head>
<body>
<div align="center">
	<div><h1>상품 수정하기</h1></div>
	<div>
		<form id="frm" name="frm" action="ProductUpdate.do" method="post">
			<div>사진<input type="text" id="productThumbnail" name="productThumbnail" ></div>
			<div>상품명<input type="text" id="productName" name="productName" ></div>
			<div>카테고리1<input type="text" id="productCategory1" name="productCategory1" ></div>
			<div>카테고리2<input type="text" id="productCategory2" name="productCategory2" ></div>
			<div>상품정보<input type="text" id="productInfo" name="productInfo" ></div>
			<div>상품옵션1<input type="text" id="productOption1" name="productOption1" ></div>
			<div>세부옵션1<input type="text" id="option1Detail" name="option1Detail" ></div>
			<div>상품옵션2<input type="text" id="productOption2" name="productOption2" ></div>
			<div>세부옵션2<input type="text" id="option2Detail" name="option2Detail" ></div>
			<div>상품재고량<input type="text" id="productStock" name="productStock" ></div>
			<div>상품가격<input type="text" id="productPrice" name="productPrice" ></div>
			<input type="submit" value="수정하기">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
			<input type="button" value="home" onclick="location.href='home.do'">
			
		</form>
	</div>
	</div>
</body>
</html>