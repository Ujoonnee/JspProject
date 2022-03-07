<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>

</head>
<body>
	<div align = "left"> 회원 리스트</div>
	<br><br>
	<div align="center">
	<form action="userInfo.do" id="frm">
		<input type="hidden" id="selectedUser" name="selectedUser" value="">
		<table border = "1">
			<tr>
				<th width="25%">serial</th>
				<th width="25%">id</th>
				<th width="25%">이름</th>
				<th width="25%">가입날짜</th>
			</tr>
		<c:forEach var="list" items="${list}">
			<tr class="userInfo">
				<td width="25%">${list.userNum }</td>
				<td width="25%" class="userId">${list.userId }</td>
				<td width="25%">${list.userName }</td>
				<td width="25%">${fn:substring(list.userSignupDate,0,11) }</td>
			</tr>
		</c:forEach>
			
		</table>
	</form>
	</div>
	
	<script>
		const list = document.getElementsByClassName('userInfo') 
		
		for (let i=0; i<list.length; i++) {
			list[i].addEventListener('click', selectUser);	
		}

		
		function selectUser() {
			let selectedTr = event.target.parentNode;
			
			const selectedUser = document.querySelector('#selectedUser');
			selectedUser.value = selectedTr.childNodes[3].innerText;
			
			frm.submit();
		}
		
		
		
				
	</script>
</body>
</html>