<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
<script>
	function formCheck(){
		if(frm.userId.value == ""){
			alert("아이디를 입력하세요.");
			frm.userId.focus();
			return false;
		}
		if(frm.userPw.value ==""){
			alert("패스워드를 입력하세요.");
			frm.userPw.focus();
			return false;
		}
		
		frm.submit();
	}
</head>
<body>
</script>
<div align="center">
	<div>
		<form id="frm" name="frm" action="userLogin.do" method="post">
			<div>
			<table>
				<tr>
				<th><input type="text" id = "userId" name="userId" placeholder="id"></th>
				</tr>
				<tr>
				<th><input type="text" id = "userPw" name="userPw" placeholder="pw"></th>
				</tr>
			</table>
			</div><br>
			<div>
				<tr>
				<th width= "400"><button type="button" onclick="formCheck()">로그인</button></th>
				</tr>
				<br>
				<tr>
				
				<th width = "200"><button type="button" onclick="location.href='#'">id찾기</button></th>
				<th width = "200"><button type="button" onclick="location.href='#'">pw찾기</button></th>
				</tr>
				<br>
				<tr>
				<th width = "400"><button type="button" onclick="location.href='user/userSignUpForm.do'">회원가입</button></th>
				</tr>
			</div>
		</form>
	</div>
</div>
</body>
</html>