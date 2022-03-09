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

		<!-- Mobile Nav (max width 767px)-->
		<div class="mobile-nav">
			<!-- Navbar Brand -->
			<div class="amado-navbar-brand">
				<a href="main.do"><img src="img/core-img/logo.png" alt=""></a>
			</div>
			<!-- Navbar Toggler -->
			<div class="amado-navbar-toggler">
				<span></span><span></span><span></span>
			</div>
		</div>

		<!-- Header Area Start -->
		<header class="header-area clearfix">
			<!-- Close Icon -->
			<div class="nav-close">
				<i class="fa fa-close" aria-hidden="true"></i>
			</div>




			<!-- Amado Nav -->
			<jsp:include page="../layout/sidebar.jsp"></jsp:include>




			<!-- Cart Menu -->
			<div class="cart-fav-search mb-100">
				<a href="cart.do" class="cart-nav"><img
					src="img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
			</div>

			<!-- Social Button -->
			<div class="social-info d-flex justify-content-between">
				<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
			</div>
		</header>
	<div>
		<c:choose>
		<c:when test="${empty keyword }">
			<table class="table" border="1">
					
					<c:forEach var="list" items="${productList}">
						<div class="single-products-catagory clearfix">
													
						<thead>
							<tr>
							<th align="center" colspan="2">
							<a href="productDetail.do?productSerial=${list.productSerial }" > <img
							src="${list.productThumbnail }" alt="${list.productName }"/></a>
								</th>
							</tr>

						</thead>

						<tbody>
							<tr>
								<td align="center">${list.productName}</td>
								<td align="center">${list.productPrice}</td>
							</tr>
							
						</tbody>
							</div>
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