<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheck.jsp</title>
<jsp:include page="../layout/head.jsp"/>
</head>
<body>
<jsp:include page="../layout/myPageSidebar.jsp"/>
<form action="myPageCheck.do" id="frm">
	<input type="hidden"  value="${user.userId }">
	<input type="password" name="userPw" placeholder="pw 확인"><input type="submit" value="검색">
</form>
</body>
</html>