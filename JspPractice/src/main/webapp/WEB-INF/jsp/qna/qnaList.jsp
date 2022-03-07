<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna.jsp</title>
</head>
<body>


	<table border = "1">
		<tr>
			<th align = "left"> 1:1문의</th>
		</tr>
		<tr align = "center">
			<th width = "20%">문의유형</th>
			<th width = "20%">제목</th>
			<th width = "20%">주문번호</th>
			<th width = "20%">작성일</th>
			<th width = "20%">처리상태</th>
		</tr>
		<c:forEach var="qna" items="${list}">
		<tr align= "center">
			<td width="20%">${qna.qnaType }</td>
			<td width="20%">${qna.qnaTitle }</td>
			<td width="20%">${qna.orderNum }</td>
			<td width="20%">${qna.qnaDate }</td>
			<td width="20%">${qna.qnaStatus }</td>
		</tr>
		</c:forEach>
		
	</table>
		<input type="button" onclick = "location.href='qnaForm.do'"value="1:1문의하기">
</form>
	
</body>
</html>