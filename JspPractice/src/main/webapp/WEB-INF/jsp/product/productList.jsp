<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:include page="../layout/head.jsp"></jsp:include>

	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper d-flex clearfix">

		<!-- Header Area Start -->
		<header class="header-area clearfix">

			<!-- Amado Nav -->
			<jsp:include page="../layout/sidebar.jsp"></jsp:include>

			<!-- Cart Menu -->
			<div class="cart-fav-search mb-100">
				<a href="cart.do" class="cart-nav"><img
					src="img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
			</div>
		</header>

		<c:choose>
			<c:when test="${empty keyword }">

				<table style="width: 70%; height: 30vh">
					<colgroup>
							<col style="width: 50%;">
							<col>
					</colgroup>

					<c:forEach var="product" items="${productList}">
						<tbody onclick="location.href='productDetail.do?productSerial=${product.productSerial}'">
							<tr style="border-top: 1px solid lightgrey;">
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td rowspan="2"><img src="${product.productThumbnail }"
									alt="${product.productName }" width="200px" height="240px">
								</td>
								<td>${product.productName }</td>
							</tr>
							<tr>
								<td>${product.productPrice }원</td>
							</tr>
							<tr style="border-bottom: 1px solid lightgrey;">
								<td>&nbsp;</td>
							</tr>
						</tbody>
					</c:forEach>

				</table>

			</c:when>

			<c:when test="${ empty searchList }">
				<h1>검색 결과가 없습니다.</h1>
			</c:when>

			<c:when test="${ not empty searchList }">
				<table style="width: 70%; height: 30vh">
					<colgroup>
						<col style="width: 50%;">
						<col>
					</colgroup>

					<c:forEach var="list" items="${searchList}">
						<tbody>
							<tr style="border-top: 1px solid lightgrey;">
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td rowspan="2"><img src="${list.productThumbnail }"
									alt="${list.productName }" width="200px" height="240px">
								</td>
								<td>${list.productName }</td>
							</tr>
							<tr>
								<td>${list.productPrice }원</td>
							</tr>
							<tr style="border-bottom: 1px solid lightgrey;">
								<td>&nbsp;</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>