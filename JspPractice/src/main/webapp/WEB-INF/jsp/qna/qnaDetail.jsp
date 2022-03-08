<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaDetail.jsp</title>
</head>
<body>
<jsp:include page="../layout/head.jsp"/>
<jsp:include page="../layout/myPageSidebar.jsp"/>
	<div>
		<table border='1'>
			<tr>
			<td width = '20%'>제목</td>
			<td width = '80%'>${qna.qnaTitle }</td>
			</tr>
			<tr>
			<td width = '20%'>주문번호</td>
			<td width = '80%'>${qna.orderNum }</td>
			</tr>
			<tr>
			<td width = '20%'>작성일</td>
			<td width = '80%'>${qna.qnaDate }</td>
			</tr>
			<tr>
			<td colspan='2' height = '100px'>
			
			${qna.qnaContent }</td>
			</tr>
		</table>
		
		<c:if test="${user.userAuthority eq 'admin' }">
		<form action = "qnaForm.do " method ="post">
			<input type="hidden" name = "qnaDate" value="${qna.qnaDate }">			
			<input type="submit" value="수정하기"> 
		</form>
		</c:if>
	</div>
</body>
</html>