<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaDetail.jsp</title>
<script>
	 $(function check() {
	        if (document.search.keyWord.value == "") {
	            alert("검색어를 입력하세요.");
	            document.search.keyWord.focus();
	            return;
	        }
	        document.search.submit();
	    });

	    function list() {
	        document.list.action = "qnaAdmin.do";
	        document.list.submit();
	    }
	    function read(value) {
	        document.read.action = "qnaAdmin.do";
	        document.read.seq.value = value; // 해당 게시글 번호
	        document.read.keyField.value = document.search.keyField.value;
	        document.read.keyWord.value = document.search.keyWord.value;
	        document.read.submit();
	    }

	function f(){
	$.ajax({
		type: 'post',
		url : '/qna/qnaAdmin.do'
		dataType : 'json',
		success :function(){
			alert("reply load Succesd");
		},
		error : function(){
			alert("reply load Failed");
		}
	});
	}
	
	  const list = document.getElementsByClassName('#qnaInfo')
		
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
</head>
<body>
<div>
<b>주문목록</b>
<form action = "qnaAdmin.do" method="post">
	<table>
		<tr>
		<th><select name="qna_type">
			<option value="">선택하세요</option>
			<option value="qnaType"<c:if test="${'qnaType'==qna_type }"> selected</c:if>>문의유형</option>
			<option value="userId"<c:if test="${'userId'==qna_type }"> selected</c:if>>구매자ID</option>
			<option value="qnaTitle"<c:if test="${'qnaTitle'==qna_type }"> selected</c:if>>제목</option>
			<option value="qnaStatus"<c:if test="${'qnaStatus'==qna_type }"> selected</c:if>>상태</option>
		</select><input type = "text" name = "keyWord" value="${keyWord} "><input type =button value="검색" onClick="check()"></th>
		</tr>
	</table>
</form>
	
<form id ="frm" name="frm" action="qnaDetail.do" method="post">
	<input type="hidden" id ="selectedQna" name ="selectedQna" value="">
	<table border='1'>
		<c:choose>
			<c:when test="${empty list }">
	                    등록된 글이 없습니다.
	        </c:when>
	        <c:otherwise>
			<tr>
			<th width='25%'>문의유형</th>
			<th width='25%'>구매자ID</th>
			<th width='25%'>제목</th>
			<th width='25%'>상태</th>
		</tr>
		<c:forEach var="list" items="${list }" > 
		<tr class = "qnaInfo">
			<td width='25%'>${list.qnaType }</td>
			<td width='25%'>${list.userId }</td>
			<td width='25%'>${list.qnaTitle }</td>
			<td width='25%'>${list.qnaStatus }
			<input type="hidden"name="orderNum" value="${list.orderNum }">
			</td>
		</tr>
		 </c:forEach> 
		</c:otherwise>
	 </c:choose>
	</table>
</form>
</div>
	
	
</html>

