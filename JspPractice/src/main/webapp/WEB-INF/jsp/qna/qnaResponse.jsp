<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
<form action = "qnaUpdate.do" method ="post">
<c:forEach var ="list" items="${list }">

		<table border='1'>
			<tr>
			<td width = '20%'>제목</td>
			<td width = '80%'>${list.qnaTitle }</td>
			</tr>
			<tr>
			<td width = '20%'>주문번호</td>
			<td width = '80%'>${list.orderNum }</td>
			</tr>
			<tr>
			<td width = '20%'>작성일</td>
			<td width = '80%'>${fn:substring(list.qnaDate,0,16 ) }</td>
			</tr>
			<tr>
			<td colspan='2' height = '100px'><textarea class="form-control" name="responseContent" maxlength="2048" style="height : 350px; width : 100%;" >${list.qnaContent }
			</textarea>
			
			</td>
			</tr>
		</table>
		</c:forEach>
		<input type="hidden" name="qnaDate" value="${list.qnaDate }">
		<input type="submit" class="btn" value="수정하기"/>
</form>
	</div>
<script>
	/* $('#text').val().replace(/\n/g, "<br>") */
	alert("여기는 qnaResponse하는곳");
</script>
</body>
</html>