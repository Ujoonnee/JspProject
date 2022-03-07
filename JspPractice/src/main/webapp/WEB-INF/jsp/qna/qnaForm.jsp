<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaForm.jsp</title>
<script>
	function go() {
		

		frm.submit();
	}
</script>
</head>
<body>
<div align="center">
<form action="qnaList.do" id ="frm">
<table border='1'>
	<tr>
		<th align="left"><p>문의작성</p></th>
	</tr>
	<tr>
		<td>문의유형</td>
		<td><label for="qna_type"></label>
			<select id="qna_type" name="qna_type" size="1">
			<option value="">선택하세요.</option>
			<option value = "change">교환</option>
			<option value = "refund">환불</option>
			<option value = "cancel">취소(출하 전 신청)</option>
			<option value = "etc">기타</option>
			</select></td>
		<td>작성자</td>
		<td><input type="text" id="qna_type" name="qna_type" placeholder="db.작성자" ></td>
		<td></td>
	</tr>
	<tr>
		<td rowspan='2'>주문번호</td>
		<td><input type="text" id="qna_type" name="qna_type" placeholder="serailNum을 입력하세요." > &nbsp;
		<input type='button' id = '' value='조회'> </td>
		<td>휴대전화</td>
		<td><input type="text" id="qna_type" name="qna_type" placeholder="db.휴대전화" ></td>
	</tr>
	<tr>
		<td>구매한 상품들</td>
		<td>이메일</td>
		<td>이메일db</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>제목을 입력해 주세요.</td>
		<td rowspan='2'>사진</td>
		<td rowspan='2'>이미지 추가태그</td>
	</tr>
	<tr>
		<td>문의내용</td>
		<td>내용을 입력해주세요.</td>
	</tr>
	
</table>
<input type='reset' value ='취소'>
<button type='button' onclick = 'go()' >작성하기</button>
</form>

</div>
</body>
</html>