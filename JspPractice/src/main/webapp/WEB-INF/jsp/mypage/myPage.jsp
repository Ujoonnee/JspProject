<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheck.jsp</title>
</head>
<body>
<jsp:include page="../layout/myPageSidebar.jsp"></jsp:include>
<form>
<div>
	<c:choose>
	<c:when test="${not empty userId} }">
		alert('로그인하세요');
		history.back();
	</c:when>	
	<c:otherwise>
	<input type="text" placeholder="pw 확인">
	
	</c:otherwise>
	</c:choose>
</div>
</form>
</body>
</html>