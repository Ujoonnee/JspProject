<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<c:forEach var="product" items="${list }">
	<!-- Single Catagory -->
	<div class="single-products-catagory clearfix">
		<a href="shop.html"> <img src="${product.productThumbnail } alt="${product.productName }"> <!-- Hover Content -->
			<div class="hover-content">
				<div class="line"></div>
				<p>${product.productPrice }</p>
				<h4>${product.productName }</h4>
			</div>
		</a>
	</div>
</c:forEach>