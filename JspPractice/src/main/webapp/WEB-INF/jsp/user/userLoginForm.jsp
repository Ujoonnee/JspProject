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
</script>
</head>
<body>
<div align="center">
	<div>
		<form id="frm" name="frm" action="userLogin.jsp" method="post">
			<div>
			<table>
				<tr>
				<th>ID : <input type="text" id = "userId" name="userId" placeholder="id"></th>
				<th>PW : <input type="text" id = "userPw" name="userPw" placeholder="pw"></th>
				</tr>
			</table>
			</div><br>
			<div>
				<button type="button" onclick="formCheck()">로그인</button>
				
				<button type="button" onclick="">id찾기</button> 
				<button type="button" onclick="">pw찾기</button>
				<button type="button" onclick="location.href='user/userSignUpForm.jsp'">회원가입</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>