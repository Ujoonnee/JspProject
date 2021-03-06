<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문페이지</title>
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<jsp:include page="../layout/head.jsp"></jsp:include>

	<div class="main-content-wrapper d-flex clearfix">

		<header class="header-area clearfix">
			<jsp:include page="../layout/sidebar.jsp"></jsp:include>
		</header>

		<div class="col-12 col-lg-8">
			<form action="">
				<div id="productInfo">
					<h1>제품정보</h1>
					<table border="1"
						style="width: 100%; border-left: none; border-right: none;">
						<colgroup>
							<col width="20%">
							<col width="30%">
							<col width="20%">
							<col width="30%">
						</colgroup>
						<tr style="font-size: 20px; text-align: center;">
							<th>사진</th>
							<th>상품이름</th>
							<th>수량</th>
							<th>주문금액</th>
						</tr>
						<tr>
							<td><img src="${productThumbnail}" width="200" height="240"></td>
							<td>${productName}</td>
							<td>${productQuantity}</td>
							<td>${productQuantity * productPrice}</td>
						</tr>
					</table>
				</div>
				<br> <br>
				<div id="shippingInfo">
					<h1>배송정보</h1>
					<table 
						style="border-left: none; border-right: none; width: 100%; margin-left: auto; margin-right: auto;">
						<colgroup>
							<col width="30%">
							<col width="70%">
						</colgroup>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th>배송지 선택</th>
							<td><input type="radio" name="addressType" value="1" checked><span
								style="margin-right: 2em;"> 회원정보와 동일</span><input type="radio"
								name="addressType" value="2"><span
								style="margin-right: 2em;"> 새 배송지</span> <input type="radio"
								name="addressType" value="3"><span
								style="margin-right: 2em;"> 기존 배송지</span></td>
						</tr>
						<tr>
							<th>배송지 주소</th>
							<td><input type="text" name="shippingAddress" id=""
								size="50" required></td>
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
							<td><input type="text" name="shippingComment" id=""
								size="50"></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2"><div id="addressList" style="display: none;"></div></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<th colspan="2"><input type="submit" onclick="purchase"
								value="결제하기"></th>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
					</table>
				</div>
				<br>

			</form>
		</div>
	</div>

	<script>
		window.onload = sameWithUserInfo;
	
		function purchase() {
			alert('purchase');
			event.preventDefault();
			const checked = document.getElementsByTagName("input[name='addressType']:checked");
			console.log(checked);
			console.log(checked.value);
		}
		
		// select type of address
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
		
		
		
		// fill out shipping form
		const shippingAddress = document.querySelector("input[name=shippingAddress]");
		const recipientName = document.querySelector("input[name=recipientName]");
		const phoneNumber = document.querySelector("input[name=phoneNumber]");
		const shippingComment = document.querySelector("input[name=shippingComment]");
		
		
		function sameWithUserInfo() {
			addressList.style.display = 'none';
			shippingAddress.value = "<c:out value='${user.userAddress}'/>";
			recipientName.value = "<c:out value='${user.userName}'/>";
			phoneNumber.value = "<c:out value='${user.userTel}'/>";
			shippingComment.value = '';
		}
		
		function newAddress() {
			addressList.style.display = 'none';
			shippingAddress.value = '';
			recipientName.value = '';
			phoneNumber.value = '';
			shippingComment.value = '';
		}
		
		
		// print address list of current user
		function showShippingAddressList() {
			addressList.innerHTML = '';
			addressList.style.display = 'block';
			
			const h3 = document.createElement('h3');
			const name = '<c:out value="${user.userName}"/>';
			h3.innerText = name + '님의 배송지 목록';
			addressList.appendChild(h3);
			
			// get address list
			fetch('shippingAddressListAjax.do', {
	              method: 'POST',
	              headers: {'Content-Type':'application/x-www-form-urlencoded'},
	           })
	           .then(response => response.json())
	           .then(result => {
	        	   const table = document.createElement('table');
	        	   table.setAttribute('border', '1');
	        	   table.setAttribute('style','margin-left: auto; margin-right: auto;');
	        	   addressList.appendChild(table);
	        	   
	        	   // thead
	        	   const thead = document.createElement('thead');
	        	   table.appendChild(thead);
	        	   
	        	   const theadTr = document.createElement('tr');
	        	   thead.appendChild(theadTr);
	        	   
	        	   const theadAddress = document.createElement('th');
	        	   theadAddress.innerText = '배송지 주소';
	        	   theadTr.appendChild(theadAddress);
	        	   
	        	   const theadRecipientName = document.createElement('th');
	        	   theadRecipientName.innerText = '받는 사람';
	        	   theadTr.appendChild(theadRecipientName);
	        	   
	        	   const theadPhoneNumber = document.createElement('th');
	        	   theadPhoneNumber.innerText = '연락처';
	        	   theadTr.appendChild(theadPhoneNumber);
	        	   
	        	   const theadShippingComment = document.createElement('th');
	        	   theadShippingComment.innerText = '배송 메모';
	        	   theadTr.appendChild(theadShippingComment);
	        	   
	        	   // tbody
	        	   // print a table of address list
	        	   const tbody = document.createElement('tbody');
	        	   table.appendChild(tbody);
	        	   for (const address of result) {
	        	    	const tbodyTr = document.createElement('tr');
	        	    	tbody.appendChild(tbodyTr);
	        	    	
	        	    	const addressTd = document.createElement('td');
	        	    	addressTd.innerText = address.shippingAddress;
	        	    	tbodyTr.appendChild(addressTd);
	        	    	
	        	    	const recipientTd = document.createElement('td');
	        	    	recipientTd.innerText = address.recipientName;
	        	    	tbodyTr.appendChild(recipientTd);
	        	    	
	        	    	const phoneNumberTd = document.createElement('td');
	        	    	phoneNumberTd.innerText = address.phoneNumber;
	        	    	tbodyTr.appendChild(phoneNumberTd);
	        	    	
	        	    	const shippingCommentTd = document.createElement('td');
	        	    	shippingCommentTd.innerText = address.shippingComment;
	        	    	tbodyTr.appendChild(shippingCommentTd);
	        	    	
	        	    	tbodyTr.addEventListener('click', () => {
	        	    		shippingAddress.value = address.shippingAddress;
	        	    		recipientName.value = address.recipientName;
	        	    		phoneNumber.value = address.phoneNumber;
	        	    		shippingComment.value = address.shippingComment;
	        	    	});
	        	    	
				   }
	        	   
	           })
		}
		
	</script>
</body>

</html>