<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaDetail.jsp</title>
</head>
<body>
<div>
<b>주문목록</b>
<form action = "qnaDetail.do" method="post">
	<table>
		<tr>
		<th><select id="qna_type" name="qna_type">
			<option value="">선택하세요</option>
			<option value="qnaType">문의유형</option>
			<option value="userId">구매자ID</option>
			<option value="qnaTitle">제목</option>
			<option value="qnaStatus">상태</option>
		</select></th>
		<th><input type = "text" name = "value"><input type ="submit" value="검색"></th>
		</tr>
	</table>
</form>
	
<form id ="frm" name="frm" action="qnaDetail.jsp">
	<input type="hidden" id ="selectedQna" name ="selectedQna" value="">
	<table border='1'>
		<tr>
			<th width='25%'>문의유형</th>
			<th width='25%'>구매자ID</th>
			<th width='25%'>제목</th>
			<th width='25%'>상태</th>
		</tr>
		<c:forEach var="list" items="${list }">
		<tr class = "qnaInfo">
			
			<td width='25%'>${list.qnaType }</td>
			<td width='25%' >${list.userId }</td>
			<td width='25%' >${list.qnaTitle }</td>
			<td width='25%'>${list.qnaStatus }
			<input type="hidden"name="orderNum" value="${list.orderNum }">
			</td>
			
			
		</tr>
		</c:forEach>
	 
	</table>
</form>
</div>
	<script>
	const list = document.getElementsByClassName('qnaInfo')
	
	for(let i = 0; i<list.length; i++){
		list[i].addEventListener('click', selectedQna);
	}
	
	function selectedQna(){
		let selectedTr = event.target.parentNode;
		
		const selectedUser = document.querySelector('#selectedQna');
		selectedUser.value = selectedTr.childNodes[7].innerText;
		frm.submit();
	}
	</script>
</body>
</html>

