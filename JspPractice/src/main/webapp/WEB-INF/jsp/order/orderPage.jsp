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
		<div id="productInfo">
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
		</div>

		<div id="shippingInfo">
			<h1>배송정보</h1>
			<table border="1">
				<tr>
					<th>배송지 선택</th>
					<td><input type="radio" name="addressType" value="1" checked><span>회원정보와
							동일</span><input type="radio" name="addressType" value="2"><span>새
							배송지</span> <input type="radio" name="addressType" value="3"><span>기존
							배송지</span></td>
				</tr>
				<tr>
					<th>배송지 주소</th>
					<td><input type="text" name="shippingAddress" id="" size="50"
						required></td>
				</tr>
				<tr>
					<th>받는 사람</th>
					<td><input type="text" name="recipientName" id="" size="50"
						required></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" name="phoneNumber" id="" size="50"
						required></td>
				</tr>
				<tr>
					<th>배송 메모</th>
					<td><input type="text" name="shippingComment" id="" size="50"></td>
				</tr>
			</table>
		</div>
		
		<div id="addressList">
			
		</div>

	</form>
	<input type="submit" onclick="purchase" value="결제하기">


	<script>
		window.onload = sameWithUserInfo;
	
		function purchase() {
			alert('purchase');
			event.preventDefault();
			const checked = document.getElementsByTagName("input[name='addressType']:checked");
			console.log(checked);
			console.log(checked.value);
		}
		
		const addressType1 = document.getElementsByName("addressType")[0];
		addressType1.addEventListener('click', sameWithUserInfo);
		
		const type1Span = addressType1.nextSibling;
		type1Span.addEventListener('click', () => addressType1.checked = true);
		type1Span.addEventListener('click', sameWithUserInfo);
		
		
		const addressType2 = document.getElementsByName("addressType")[1];
		addressType2.addEventListener('click', newAddress);
		
		const type2Span = addressType2.nextSibling;
		type2Span.addEventListener('click', () => addressType2.checked = true);
		type2Span.addEventListener('click', newAddress);
		
		
		const addressType3 = document.getElementsByName("addressType")[2];
		addressType3.addEventListener('click', showShippingAddressList);
		
		const type3Span = addressType3.nextSibling;
		type3Span.addEventListener('click', () => addressType3.checked = true);
		type3Span.addEventListener('click', showShippingAddressList);
		
		
		
		const shippingAddress = document.querySelector("input[name=shippingAddress]");
		const recipientName = document.querySelector("input[name=recipientName]");
		const phoneNumber = document.querySelector("input[name=phoneNumber]");
		const shippingComment = document.querySelector("input[name=shippingComment]");
		
		
		function sameWithUserInfo() {
			shippingAddress.value = "<c:out value='${user.userAddress}'/>";
			recipientName.value = "<c:out value='${user.userName}'/>";
			phoneNumber.value = "<c:out value='${user.userTel}'/>";
			shippingComment.value = '';
		}
		
		function newAddress() {
			shippingAddress.value = '';
			recipientName.value = '';
			phoneNumber.value = '';
			shippingComment.value = '';
		}
		
		function showShippingAddressList() {
			fetch('shippingAddressListAjax.do?', {
	              method: 'POST',
	              headers: {'Content-Type':'application/x-www-form-urlencoded'},
	              body: 'type=' + type +'&text=' + text
	           })
	           .then(response => {
	                 console.log(response);
	                 return response.text();
	              })
	           .then(text => {
	              console.log(text);
	           })
		}
		
	</script>
</body>

</html>