<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna.jsp</title>
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
	<jsp:include page="../layout/head.jsp" />
</head>
<body>
	<jsp:include page="../layout/myPageSidebar.jsp" />
	<form action="qnaDetail.do" id="frm" method="post">
		<input type="hidden" id="selectedQna" name="selectedQna" value="">
		<table border="1">
			<thead>
				<tr>
					<th colspan="5" style="text-align: center; font-size: 25px;">
						<div style="display: block;">1:1문의</div>
					</th>
				</tr>
				<tr style="border: none;">
					<td>&nbsp;</td>
				<tr>
				<tr style="border-top: none; border-bottom: none;">
					<th style="text-align: center; font-size: 25px;"><select
						name="searchType" id="searchType">
							<option value="qna_type">문의유형</option>
							<option value="qna_title">제목</option>
							<option value="order_num">주문번호</option>
							<option value="qna_date">작성일</option>
							<option value="qna_status">처리상태</option>
					</select></th>
					<th colspan="3" style="text-align: center; font-size: 25px;">
						<input type="text" name="searchText" id="searchText"
						style="width: 100%">
					</th>
					<th style="text-align: center; font-size: 25px;"><input
						type="button" id="searchBtn" value="검색하기"></th>
				</tr>
				<tr style="border: none;">
					<td>&nbsp;</td>
				<tr>
				<tr align="center">
					<th width="20%">문의유형</th>
					<th width="20%">제목</th>
					<th width="20%">주문번호</th>
					<th width="20%">작성일</th>
					<th width="20%">처리상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="qna" items="${list}">
					<tr align="center" class="qnaInfo">
						<td width="20%">${qna.qnaType }</td>
						<td width="20%">${qna.qnaTitle }</td>
						<td width="20%">${qna.orderNum }</td>
						<td width="20%">${qna.qnaDate }</td>
						<td width="20%">${qna.qnaStatus }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="button" onclick="location.href='main.do'" value="main">
		<input type="button" onclick="location.href='qnaForm.do'"
			value="1:1문의하기">
	</form>
	<script>
	
		function searchQnaList() {
			const type = document.getElementById('searchType').value;
			const text = document.getElementById('searchText').value;
			fetch('qnaListAjax.do?', {
				method: 'POST',
				 headers: {
							 'Content-Type':'application/x-www-form-urlencoded;  charset=UTF-8',
							 
							},
				 body: 'type=' + type +'&text=' + text
			})
			.then(response => response.json())
	        .then(result => {
				const tbody = document.getElementsByTagName('tbody')[0];
				tbody.innerHTML = '';
				
				for (let qna of result) {
					const tr = document.createElement('tr');
					tr.setAttribute('align', 'center');
					tr.addEventListener('click', selectQna);
					
					tbody.appendChild(tr);
					
					const qnaType = document.createElement('td');
					qnaType.setAttribute('width', '20%');
					qnaType.innerText = qna.qnaType;
					tr.appendChild(qnaType);
					
					const qnaTitle = document.createElement('td');
					qnaTitle.setAttribute('width', '20%');
					qnaTitle.innerText = qna.qnaTitle;
					tr.appendChild(qnaTitle);
					
					const orderNum = document.createElement('td');
					orderNum.setAttribute('width', '20%');
					orderNum.innerText = qna.orderNum;
					tr.appendChild(orderNum);
					
					const qnaDate = document.createElement('td');
					qnaDate.setAttribute('width', '20%');
					qnaDate.innerText = qna.qnaDate;
					tr.appendChild(qnaDate);
					
					const qnaStatus = document.createElement('td');
					qnaStatus.setAttribute('width', '20%');
					qnaStatus.innerText = qna.qnaStatus;
					tr.appendChild(qnaStatus);
				}
	        });
	        
		}
		
		searchBtn.addEventListener('click', searchQnaList);

		const list = document.getElementsByClassName('qnaInfo')

		for (let i = 0; i < list.length; i++) {
			list[i].addEventListener('click', selectQna);
		}

		function selectQna() {
			let selectedTr = event.target.parentNode;

			const selectedUser = document.querySelector('#selectedQna');
			selectedUser.value = selectedTr.childNodes[7].innerText;

			frm.submit();
		}
	</script>
</body>
</html>