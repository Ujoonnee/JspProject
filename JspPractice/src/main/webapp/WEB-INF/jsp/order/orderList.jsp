<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<body>
	<div>
		<select id="selectbox" onchange="changeSelect()"
			style="display: inline-block;">
			<option value="order_num">주문번호</option>
			<option value="product_name">제품명</option>
			<option value="user_id">구매자ID</option>
			<option value="user_name">구매자이름</option>
			<option value="order_date">주문일시</option>
		</select>
	</div>
	<input type="text" id="searchBox" style="display: inline-block;">
	<input type="button" style="display: inline-block;" id="searchBtn" name="searchBtn" value="검색" onclick="textSelect()">


	<div>
		<table border="1">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>제품명</th>
					<th>구매자ID</th>
					<th>구매자이름</th>
					<th>주문일시</th>
				</tr>
			</thead>
			<tbody id=tbody>
					<c:forEach var="list" items="${orderList}">
						<tr>
							<td>${list.orderNum}</td>
							<td>${list.productName}</td>
							<td>${list.userId}</td>
							<td>${list.userName}</td>
							<td>${list.orderDate}</td>
							</tr>
					</c:forEach>
			
			</tbody>
		</table>
		<button type="button" onclick="location.href='main.do' ">MAIN</button>
	</div>

	<script>
		
		let type;
		function changeSelect(){ 
			var langSelect = document.getElementById("selectbox"); // select element에서 선택된 option의 value가 저장된다.
			var selectValue = langSelect.options[langSelect.selectedIndex].value; // select element에서 선택된 option의 text가 저장된다. 
			type = selectValue;
			
			
		}

		let text;
		function textSelect() {
			text = document.getElementById('searchBox').value;
		}
		
		
		function selectOne(response){
			for(var i=0; i<response.length; i++){
					let tr = document.createElement('tr');
	 				tbody.appendChild(tr);
					let td1 = document.createElement('td');
					let td2 = document.createElement('td');
					let td3 = document.createElement('td');
					let td4 = document.createElement('td');
					let td5 = document.createElement('td');
		
					td1.appendChild(document.createTextNode(response[i].orderNum));
					td2.appendChild(document.createTextNode(response[i].productName));
					td3.appendChild(document.createTextNode(response[i].userId));
					td4.appendChild(document.createTextNode(response[i].userName));
					td5.appendChild(document.createTextNode(response[i].orderDate));
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					tr.appendChild(td5);
	 				
             }
		}
		
		document.querySelector('#searchBtn').addEventListener('click', () => {
			document.getElementsByTagName('tbody')[0].innerHTML = '';
 			 fetch('orderAjax.do?', {
 				 method: 'POST',
 				 headers: {
 							 'Content-Type':'application/x-www-form-urlencoded;  charset=UTF-8',
 							 'dataType': 'text',
 							},
 				 body: 'type=' + type +'&text=' + text
 			 })
 			 .then(response => {
 				console.log(response.status);
 					return response.json();
 				 })
 			 .then(response => {
 				selectOne(response);	 
 				 

 			 })
 			 
			 
		})
		
		
	</script>
</body>
</html>