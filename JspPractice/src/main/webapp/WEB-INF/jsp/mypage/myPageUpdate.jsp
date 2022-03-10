<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPageUpdate.jsp</title>
<jsp:include page="../layout/head.jsp"/>
</head>
<body>
<jsp:include page="../layout/myPageSidebar.jsp"/>
<form action="myPageUpdate.do" id="frm" method="post">
	
	<div><input type="password" id="pw" name="pw" placeholder="변경할 pw" required></div>
	<div><input type="password" id="pw1" name="pw1" placeholder="pw확인" required></div>
	<div><input type="text" id="userTel" name="userTel" placeholder="전화번호" ></div>
	<div><input type="text" id="userEmail" name="userEmail" placeholder="이메일" ></div>
	<div><input type="text" id="userAddress" name="userAddress" placeholder="주소" ></div>
	
	<input type="button" value="home" onclick="location.href='home.do'">
	<input type="submit" id = "userUpdate" value="회원 수정">
</form>
<script>

function frmChk(){
	event.preventDefault();
	if (pw.value != pw1.value) {
			alert('비밀번호가 일치하지 않습니다');
			return;
		}
	alert('회원수정 완료');
		frm.submit();
}
	userUpdate.addEventListener('click',frmChk);
	
</script>
</body>
</html>