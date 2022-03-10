<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
<jsp:include page="../layout/head.jsp"/>
</head>
<body>
<jsp:include page="../layout/myPageSidebar.jsp"/>
	<div align="left">
		<div>
			<table border="1">
				<tr>회원 상세정보
				</tr>
			</table>
		</div>
		<div>
			<form action="myPageUpdate.do" id="frm" method="post">
				<table border="1">
					<tr>
						<th width="30%">회원번호</th>
						<th width="70%">${user.userNum }</th>
					</tr>
					<tr>
						<th width="30%">id</th>
						<th width="70%">${user.userId }</th>
					</tr>
					<tr>
						<th width="30%">pw</th>
						<th width="70%"><input type="password" id="pw" name="pw"
							placeholder="변경할 pw" required></th>
					</tr>
					<tr>
						<th width="30%">pw확인</th>
						<th width="70%"><input type="password" id="pw1" name="pw1"
							placeholder="pw확인" required></th>
					</tr>
					<tr>
						<th width="30%">이름</th>
						<th width="70%">${user.userName }</th>
					</tr>
					<tr>
						<th width="30%">dob</th>
						<th width="70%">${user.userDob }</th>
					</tr>
					<tr>
						<th width="30%">가입날짜</th>
						<th width="70%">${user.userSignupDate }</th>
					</tr>
					<tr>
						<th width="30%">전화번호</th>
						<th width="70%"><input type="text" id="userTel"
							name="userTel" placeholder="전화번호" value="${user.userTel }"></th>
					</tr>
					<tr>
						<th width="30%">이메일</th>
						<th width="70%"><input type="text" id="userEmail"
							name="userEmail" placeholder="이메일" value="${user.userEmail }"></th>
					</tr>
					<tr>
						<th width="30%">주소</th>
						<th width="70%"><input type="text" id="userAddress"
							name="userAddress" placeholder="주소" value="${user.userAddress }"></th>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<input type="button" onclick="history.back();" value="뒤로가기">
				<input type="submit" id="userUpdate" value="수정하기">
		</div>

	</div>

	<script>
		function frmChk() {
			event.preventDefault();
			if(pw.value ==""){
				alert('비밀번호를 입력하세요.')
				pw.focus();
				return;
			}
			if (pw.value != pw1.value) {
				alert('비밀번호가 일치하지 않습니다');
				return;
			}

			frm.submit();
		}
		userUpdate.addEventListener('click', frmChk);
	</script>
</body>
</html>