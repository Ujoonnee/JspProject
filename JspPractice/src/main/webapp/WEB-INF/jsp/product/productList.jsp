<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
</head>
<body>
	<div>
		<table class="table" border="1">
		
			<tr>
				<th align="center" colspan="2">${productList.productThumbnail}</th>
			</tr>
			<c:forEach var="product" items="${list}">
				<tr>
					<td align="center">${product.productThumbnail}</td>
					<td align="center">${product.productName}</td>
					<td align="center">${product.productPrice}</td>
				</tr>
			</c:forEach>
			</table>
	</div>
</body>
</html>