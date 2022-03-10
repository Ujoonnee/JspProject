<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
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
		<form id="frm" name="frm" action="ProductInsert.do" method="post">
		
			<div>사진<input type="text" id="productThumbnail" name="productThumbnail" value="${productSelect.productThumbnail}"></div>
			<div>상품명<input type="text" id="productName" name="productName" value="${productSelect.productName}"></div>
			<select id="productCategory1" name="productCategory1">
				<option value="shirts">shirts</option>
				<option value="outers">outers</option>
				<option value="pants">pants</option>
			</select>
			<select id="productCategory2" name="productCategory2">
				<option value="t_shirt">T-shirt</option>
				<option value="y_shirt">Y-shirt</option>
				<option value="jumper">Jumper</option>
				<option value="fleece">Fleece</option>
				<option value="sweats">Sweats</option>
				<option value="jeans">Jeans</option>
			</select>
			<div>상품정보<input type="text" id="productInfo" name="productInfo" value="${productSelect.productInfo}"></div>
			<div>상품재고량<input type="text" id="productStock" name="productStock" value="${productSelect.productStock}"></div>
			<div>상품가격<input type="text" id="productPrice" name="productPrice" value="${productSelect.productPrice}"></div>
			<input type="submit" value="저장하기">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
			<input type="button" value="home" onclick="location.href='main.do'">
			
		</form>
	</div>
	</div>
	<script type="text/javascript">

    var productCategory1 = document.getElementById('productCategory1').children;
    for(let opt of productCategory1) {
    	if(opt.value == '${productSelect.productCategory1}') {
    		opt.setAttribute('selected', true);
    	}
    }
    var productCategory2 = document.getElementById('productCategory2').children;
    for(let opt of productCategory2) {
    	console.log(opt)
    	if(opt.value == '${productSelect.productCategory2}') {
    		opt.setAttribute('selected', true);
    	}
    }

  

	</script>
</body>
</html>