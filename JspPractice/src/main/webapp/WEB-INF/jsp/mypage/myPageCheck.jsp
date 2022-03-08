<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheck.jsp</title>
</head>
<body>
<jsp:include page="../layout/head.jsp"/>
<jsp:include page="../layout/myPageSidebar.jsp"/>
<form>
	<c:if test="${not empty userId }">
		<input type="hidden" name="userId" value="${id }">
	</c:if>	
	<input type="password" name="userPw">
</form>
</body>
</html>