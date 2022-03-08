<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<!-- Logo -->
	<div class="logo" style="display: inline-block; padding: 70px;">
		<a href="main.do"><img src="img/core-img/logo.png" alt=""></a>
	</div>
	<c:choose>
		<c:when test="${user.userAuthority eq 'user'}">
			<div
				style="display: inline-block; position: absolute; top: 10px; right: 100px;">
				<a href="myPage.do"><h6>${user.userName }님</h6></a>
			</div>
			<div
				style="display: inline-block; position: absolute; top: 10px; right: 20px;">
				<a href="userLogout.do"><h6>로그아웃</h6></a>
			</div>
		</c:when>
		<c:otherwise>
			<div
				style="display: inline-block; position: absolute; top: 10px; right: 100px;">
				<a href="userLoginForm.do"><h6>로그인</h6></a>
			</div>
			<div
				style="display: inline-block; position: absolute; top: 10px; right: 20px;">
				<a href="userSignUpForm.do"><h6>회원가입</h6></a>
			</div>
		</c:otherwise>
	</c:choose>

</div>
