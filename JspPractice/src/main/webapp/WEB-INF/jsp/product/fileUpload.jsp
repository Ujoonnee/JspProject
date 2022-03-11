<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "contextPath" value="${pageContext.request.contextPath }"/>

<% 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUploadForm.do" method="post" enctype="multipart/form-data">
	파일1: <input type="file" name="file"><br>
	<input type="submit" value="업로드"><br>
	</form>
</body>
</html>