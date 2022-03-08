<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
</head>
<body>
	<div>
		<c:choose>
		<c:when test="${empty keyword }">
			<table class="table" border="1">

					<c:forEach var="list" items="${productList}">
						<div>
							<a href="productDetail.do?productSerial=${list.productSerial}">${list.productSerial}</a>
						</div>
						<thead>
							<tr>
								<th align="center" colspan="2">${list.productThumbnail}</th>
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
			</c:when>
			
			<c:when test="${ empty searchList }">
				<h1>검색 결과가 없습니다.</h1>
			</c:when>

			<c:when test="${ not empty searchList }">
				<table class="table" border="1">

					<c:forEach var="list" items="${searchList}">
						<div>
							<a href="productDetail.do?productSerial=${list.productSerial}">${list.productSerial}</a>
						</div>
						<thead>
							<tr>
								<th align="center" colspan="2">${list.productThumbnail}</th>
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
			</c:when>
			
			
		</c:choose>
		
		<button type="button" onclick="location.href='main.do' ">Main</button>
	</div>
</body>
</html>