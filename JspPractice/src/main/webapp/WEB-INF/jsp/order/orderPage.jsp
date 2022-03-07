<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문페이지</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<th>사진</th>
				<th>상품이름</th>
				<th>수량</th>
				<th>주문금액</th>
			</tr>
			<tr>
				<td>${productThumbnail}</td>
				<td>${productName}</td>
				<td>${productQuantity}</td>
				<td>${productQuantity * productPrice}</td>
			</tr>
		</table>
		<button type="button" onclick="location.href='main.do' ">MAIN</button>
	</div>
</body>
</html>