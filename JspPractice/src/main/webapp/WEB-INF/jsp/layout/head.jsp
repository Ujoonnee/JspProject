<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<!-- Logo -->
	<div class="logo" style="display: inline-block; padding: 5vw;">
		<a href="main.do"><img src="img/core-img/logo.png" alt=""></a>
	</div>
	<div style="display: inline-block; width: 5vw;"></div>
	<div
		style="display: inline-block; widht: 60vw; height: 35px; line-height: 35px;">
		<form action="searchProduct.do" method="post">
			<input type="text" name="keyword"
				style="width: 50vw; height: 35px; font-size: 15px;"
				placeholder="상품명 또는 카테고리를 입력하세요.">&nbsp;&nbsp;&nbsp;
			<button type="submit" style="height: 35px; font-size: 20px;">검색</button>
		</form>

	</div>

	<c:choose>
		<c:when test="${user.userAuthority eq 'user'}">
			<div>
				<div
					style="display: inline-block; position: absolute; top: 10px; right: 100px;">
					<a href="myPage.do"><h6>${user.userName }님</h6></a>
				</div>
				<div
					style="display: inline-block; position: absolute; top: 10px; right: 20px;">
					<a href="userLogout.do"><h6>로그아웃</h6></a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div>	
				<div
					style="display: inline-block; position: absolute; top: 10px; right: 100px;">
					<a href="userLoginForm.do"><h6>로그인</h6></a>
				</div>
				<div
					style="display: inline-block; position: absolute; top: 10px; right: 20px;">
					<a href="userSignUpForm.do"><h6>회원가입</h6></a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>
