<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
	<div align = "left"> 회원 리스트</div>
	<br><br>
	<div align="center">
		<table border = "1">
			<tr>
				<th width="25%">serial</th>
				<th width="25%">id</th>
				<th width="25%">이름</th>
				<th width="25%">가입날짜</th>
			</tr>
		<c:forEach var="user" items="${list }">
			<tr>
				<td width="25%">${user.userNum }</td>
				<td width="25%">${user.userId}</td>
				<td width="25%">${user.userName }</td>
				<td width="25%">${user.userSingupDate }</td>
			</tr>
		</c:forEach>
			
		</table>
	
	</div>
</body>
</html>