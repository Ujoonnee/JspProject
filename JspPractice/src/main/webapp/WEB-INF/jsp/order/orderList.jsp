<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
</head>
<body>
	<div style="border: solid 1px black; display: inline-block;">
		<select>
			<option></option>
			<option></option>
			<option></option>
			<option></option>
			<option></option>
		</select>
	</div>
	<input type="text" id="searchBox">
	<div style="border: solid 1px black; display: inline-block;" id="searchBtn"><span>검색</span></div>
 	<div>
		<table border="1">
			<thead>
				<tr>
					<th>주문목록</th>
					<th>주문내역</th>
					<th>구매자ID</th>
					<th>구매자이름</th>
					<th>주문일시</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${orderList }">
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
		document.querySelector('#searchBtn').addEventListener('click', () => {
			document.getElementsByTagName('tbody')[0].innerHTML = '';
			
			const list = ${orderList};
			console.log(list);
			
			
		})
	</script>
</body>
</html>