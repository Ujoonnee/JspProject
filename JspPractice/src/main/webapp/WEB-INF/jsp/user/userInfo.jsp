<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
	<div align="left">
		<div>
			<table border="1">
				<tr>회원 상세정보</tr>
			</table>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="30%">회원번호</th>
					<th width="70%">${user.userNum }</th>
				</tr>
				<tr>
					<th width="30%">id</th>
					<th width="70%">${user.userId }</th>
				</tr>
				<tr>
					<th width="30%">pw</th>
					<th width="70%">${user.userPw }</th>
				</tr>
				<tr>
					<th width="30%">이름</th>
					<th width="70%">${user.userName }</th>
				</tr>
				<tr>
					<th width="30%">dob</th>
					<th width="70%">${user.userDob }</th>
				</tr>
				<tr>
					<th width="30%">가입날짜</th>
					<th width="70%">${user.userSignupDate }</th>
				</tr>
				<tr>
					<th width="30%">전화번호</th>
					<th width="70%">${user.userTel }</th>
				</tr>
				<tr>
					<th width="30%">이메일</th>
					<th width="70%">${user.userEmail }</th>
				</tr>
				<tr>
					<th width="30%">주소</th>
					<th width="70%">${user.userAddress }</th>
				</tr>
			</table>
		</div>
		<div><input type = "button" onclick="history.back();" value="뒤로가기"></div>
	</div>
</body>
</html>