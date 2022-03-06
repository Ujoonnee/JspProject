<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSignUpForm.jsp</title>
<style>
#st {
	text-align: center;
}
</style>
</head>
<body>
	<div id="st">
		<b>회원가입</b>

		<form id="frm" name="frm" onsubmit="frmChk()" action="userSignUp.do" method="post">
			<table align="center">
				<tr>
					<td><input type="text" id="userId" name="userId"
						placeholder="*id" required> &nbsp;&nbsp; <input
						type="button" id="idchk" value="중복체크" data-checked="false"></td>
				</tr>
				<tr>
					<td><input type="text" id="userPw" name="userPw"
						placeholder="*pw" required></td>
				</tr>
				<tr>
					<td><input type="text" id="userPw1" name="userPw1"
						placeholder="*pw확인" required></td>
				</tr>
				<tr>
					<td><input type="text" id="userName" name="userName"
						placeholder="*이름" required></td>
				</tr>
				<tr>
					<td><input type="text" id="userBod" name="userBod"
						placeholder="생년월일"></td>
				</tr>
				<tr>
					<td><input type="text" id="userTel" name="userTel"
						placeholder="전화번호"></td>
				</tr>
				<tr>
					<td><input type="text" id="userEamil" name="userEmail"
						placeholder="*이메일" required></td>
				</tr>
				<tr>
					<td><input type="text" id="userAddress" name="userAddress"
						placeholder="주소"></td>
				</tr>
			</table>
			<input type="checkbox" id="consent" name="consent"> 나는 동의한다. <br> <br>
			<input type="reset" value="취소">&nbsp;&nbsp; <input
				type="button" id="signup" value="회원가입">
		</form>
	</div>
	<script>
		// 아이디 중복 체크
		idchk.addEventListener('click', () => {
			const list = "<c:out value='${list}'/>";

			if (list.includes(userId.value)) {
				alert('이미 존재하는 아이디 입니다.');
				userId.value = '';
				userId.focus();
			} else {
				alert('사용 가능한 아이디 입니다.');
				idchk.dataset.checked = 'true';
				
			}
		});
		
		userId.addEventListener('change', () => idchk.dataset.checked = 'false');
		
		
		// submit 직전 전체 체크
// 		function frmChk() {
// 			event.preventDefault();
// 			if (idchk.data.checked != 'true')
// 			if (userPw1 != userPw2)
// 			if (consent.checked != true)
// 			alert('회원가입 성공');
// 		}
		
// 		signup.addEventListener('click', frmChk);
	</script>
</body>
</html>