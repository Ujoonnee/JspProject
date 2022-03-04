<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheck.jsp</title>
</head>
<body>
<form>
	<c:if test="${not empty id }">
		<input type="hidden" name="userId" value="${id }">
	</c:if>	
	<input type="password" name="userPw">
</form>
</body>
</html>