<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheckFail.jsp</title>
<jsp:include page="../layout/head.jsp"/>
</head>
<body>
<jsp:include page="../layout/myPageSidebar.jsp"></jsp:include>
	<script>
	alert("비밀번호 불일치!");
	history.back();
	</script>
</body>
</html>