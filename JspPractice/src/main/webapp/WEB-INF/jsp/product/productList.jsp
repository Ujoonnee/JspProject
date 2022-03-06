<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
</head>
<body>
	<div>
		<table class="table" border="1">
		
			
			
			<c:forEach var="list" items="${productList}">
				<div><a href="productDetail.do?productSerial=${list.productSerial}">${list.productSerial}</a></div>
				<thead>
				 <tr>
					<th align="center" colspan="2" >${list.productThumbnail}</th>
				</tr>
			
				</thead>
				
				<tbody>
				<tr>
					<td align="center">${list.productName}</td>
					<td align="center">${list.productPrice}</td>
				</tr>
				</tbody>
			</c:forEach>
		
			
			</table>
	</div>
</body>
</html>