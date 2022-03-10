<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageCheck.jsp</title>
<<<<<<< HEAD
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
=======
<jsp:include page="../layout/head.jsp"/>
>>>>>>> branch 'main' of https://github.com/Ujoonnee/JspProject.git
</head>
<body>
<<<<<<< HEAD

	<jsp:include page="../layout/head.jsp" />
	<div class="main-content-wrapper d-flex clearfix">

		<header class="header-area clearfix">
			<jsp:include page="../layout/myPageSidebar.jsp"></jsp:include>
		</header>

		<form action="myPageCheck.do" id="frm">
			<input type="hidden" value="${user.userId }"> <input
				type="password" name="userPw" placeholder="pw 확인"><input
				type="submit" value="검색">
		</form>
	</div>
	
	<script>
		const authority = '<c:out value="${user.userAuthority}"/>';
		
		if (authority == 'admin') {
			location.href = 'qnaList.do';
		}
		
	</script>
=======
<jsp:include page="../layout/myPageSidebar.jsp"/>
<form action="myPageCheck.do" id="frm">
	<input type="hidden"  value="${user.userId }">
	<input type="password" name="userPw" placeholder="pw 확인"><input type="submit" value="검색">
</form>
>>>>>>> branch 'main' of https://github.com/Ujoonnee/JspProject.git
</body>
</html>