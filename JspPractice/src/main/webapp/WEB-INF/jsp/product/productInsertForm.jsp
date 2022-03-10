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
		<div>
			<h1>상품 등록하기</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="productInsert.do" method="post">
				<div>
					사진<input type="text" id="productThumbnail" name="productThumbnail">
				</div>
				<div>
					상품명<input type="text" id="productName" name="productName">
				</div>
				<select id="productCategory1" name="productCategory1" onchange="paintCategory2()">
					<option value="">선택</option>
					<option value="shirts">상의</option>
					<option value="outer">아우터</option>
					<option value="pants">하의</option>
				</select> 
				<select id="productCategory2" name="productCategory2"></select>
				<div>
					상품정보<input type="text" id="productInfo" name="productInfo">
				</div>
				<div>
					상품재고량<input type="text" id="productStock" name="productStock">
				</div>
				<div>
					상품가격<input type="text" id="productPrice" name="productPrice">
				</div>
				<input type="submit" value="저장하기">&nbsp;&nbsp;&nbsp; <input
					type="reset" value="취소">&nbsp;&nbsp;&nbsp; <input
					type="button" value="home" onclick="location.href='home.do'">

			</form>
		</div>
	</div>
	<script>
		function paintCategory2() {
			productCategory2.innerHTML = '';
			
			if (productCategory1.value == 'shirts') {
				const option1 = document.createElement('option');
				option1.value = 't_shirt';
				option1.innerText = 'T-shirt';
				const option2 = document.createElement('option');
				option2.value = 'y_shirt';
				option2.innerText = 'Y-shirt';
				
				productCategory2.appendChild(option1);
				productCategory2.appendChild(option2);
				
			} else if (productCategory1.value == 'outer') {
				const option1 = document.createElement('option');
				option1.value = 'jumper ';
				option1.innerText = 'Jumper ';
				const option2 = document.createElement('option');
				option2.value = 'fleece';
				option2.innerText = 'Fleece';
				
				productCategory2.appendChild(option1);
				productCategory2.appendChild(option2);
				
			} else if (productCategory1.value == 'pants') {
				const option1 = document.createElement('option');
				option1.value = 'sweat';
				option1.innerText = 'Sweats';
				const option2 = document.createElement('option');
				option2.value = 'jean';
				option2.innerText = 'Jeans';
				
				productCategory2.appendChild(option1);
				productCategory2.appendChild(option2);
			}
		}
	</script>
</body>
</html>