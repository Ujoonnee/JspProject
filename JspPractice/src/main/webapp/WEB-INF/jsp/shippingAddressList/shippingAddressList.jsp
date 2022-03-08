<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>받는 사람</th>
				<th>연락처</th>
				<th>주소</th>
				<th>메모</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="address" items="${list }">
				<tr>
					<td>${address.recipientName }</td>
					<td>${address.phoneNumber }</td>
					<td>${address.shippingAddress }</td>
					<td>${address.shippingComment }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>