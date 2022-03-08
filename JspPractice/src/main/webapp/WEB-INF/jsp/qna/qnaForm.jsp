<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaForm.jsp</title>
<script>
	
</script>
</head>
<body>
	<div align="center">
		<form id="frm" name="frm" action="qnaUserInsert.do" method="post">
			<table border='1'>
				<tr>
					<th align="left"><p>문의작성</p></th>
				</tr>
				<tr>
					<td>문의유형</td>
					<td><select id="qna_type" name="qna_type">
							<option value="">선택하세요.</option>
							<option value="change">교환</option>
							<option value="refund">환불</option>
							<option value="cancel">취소(출하 전 신청)</option>
							<option value="etc">기타</option>
					</select></td>
					<td>작성자</td>
					<td>${user.userName }</td>

					<td></td>
				</tr>
				<tr>
					<td rowspan='2'>주문번호</td>
					<td><input type="text" id="order_num" name="order_num"
						placeholder="serailNum을 입력하세요."> &nbsp; <input
						type='button' id='orderchk' value='조회' data-checked="false"></td>
					<td>휴대전화</td>
					<td>${user.userTel }</td>
				</tr>
				<tr>
					<td><select name= "purchaseList" id="purchaseList" >
						<option value="">선택하세요.</option>
						<c:forEach var= "order" items = "${orderList }" >
							<option id = "product_serial" value="${order.productSerial }">${order.productSerial }</option>
						</c:forEach>
					</select></td>
					<td>이메일</td>
					<td>${user.userEmail }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><textarea id="title" name="title"
						placeholder="제목을 입력하세요." cols="50"></textarea></td>
					<td rowspan='2'>사진</td>
					<td rowspan='2'><input type ="button" id="qna_photo" name="qna_photo">이미지 추가태그</td>
				</tr>
				<tr height='200px'>
					<td>문의내용</td>
					<td><textarea id="content" name="content"
						placeholder="내용을 입력하세요." cols="50" rows="20"></textarea></td>
						
				</tr>
			
			</table>
			<input type="hidden" id="qna_status" name="qna_status" value="답변대기">
			<input type="hidden" id="user_id" name="user_id" value = "${user.userId }">
			<button type='button' onclick="history.back()">뒤로가기</button>&nbsp;
			<input type='reset' value='취소'>&nbsp;
			<button type='button' id = "register" >작성하기</button>
		</form>

	</div>
	
	<script>
	function frmChk(){
		
		/* if(qna_type.value != null){
			alert('문의사항은 필수 입력 항목입니다.')
			return;
		} */
		/* if(title === null){
			alert('제목은 필수 입력 항목입니다.')
			return;
		}
		if(content === null){
			alert('내용은 필수 입력 항목입니다.')
			return
		} */
		alert('등록 완료')
		frm.submit();
	}
	register.addEventListener('click',frmChk);
	</script>
</body>
</html>