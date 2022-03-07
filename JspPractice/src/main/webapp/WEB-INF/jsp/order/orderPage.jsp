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
	<form action="">
		<h1>제품정보</h1>
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

		<h1>배송정보</h1>
		<table border="1">
			<tr>
				<th>배송지 선택</th>
				<td><input type="radio" name="addressType" value="1" checked>회원정보와
					동일 <input type="radio" name="addressType" value="2">새 배송지 <input type="radio" name="addressType"
						value="3">기존 배송지</td>
			</tr>
			<tr>
				<th>배송지 주소</th>
				<td><input type="text" name="shippingAddress" id="" size="50" required></td>
			</tr>
			<tr>
				<th>받는 사람</th>
				<td><input type="text" name="recipientName" id="" size="50" required></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phoneNumber" id="" size="50" required></td>
			</tr>
			<tr>
				<th>배송 메모</th>
				<td><input type="text" name="shippingComment" id="" size="50"></td>
			</tr>
		</table>

		
		<input type="submit" onclick="purchase" value="결제하기">
	</form>

	<script>
		function purchase() {
			alert('purchase');
			event.preventDefault();
			const checked = document.getElementsByTagName("input[name='addressType']:checked");
			console.log(checked);
			console.log(checked.value);
		}
	</script>
</body>

</html>