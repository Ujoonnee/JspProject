<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductInsert.jsp</title>
</head>
<body>
	<div align="center">
	<div><h1>상품 등록하기</h1></div>
	<div>
		<form id="frm" name="frm" action="productInsertForm.do" method="post">
			<div>사진<input type="text" id="productThumbnail" name="productThumbnail" ></div>
			<div>상품명<input type="text" id="productName" name="productName" ></div>
			<select id="productCategory1" name="productCategory1" >
				<option value="대분류1">대분류1</option>
				<option value="대분류2">대분류2</option>
				<option value="대분류3">대분류3</option>
			</select>
			<select id="productCategory2" name="productCategory2">
				<option value="소분류1">소분류1</option>
				<option value="소분류2">소분류2</option>
				<option value="소분류3">소분류3</option>
			</select>
			<div>상품정보<input type="text" id="productInfo" name="productInfo" ></div>
			<div>상품재고량<input type="text" id="productStock" name="productStock" ></div>
			<div>상품가격<input type="text" id="productPrice" name="productPrice" ></div>
			<input type="submit" value="저장하기">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
			<input type="button" value="home" onclick="location.href='home.do'">
			
		</form>
	</div>
	</div>
</body>
</html>