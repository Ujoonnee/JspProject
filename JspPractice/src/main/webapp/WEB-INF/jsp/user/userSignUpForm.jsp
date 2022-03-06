<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSignUpForm.jsp</title>
<style>
	#st{
		text-align:center;
	}
</style>
</head>
<body>
	<div id="st">
		<b>회원가입</b>
		
		<form id="frm" name="frm" action="userSignUpForm.do" method="post">
			<table>
				<tr>
					<td><input type="text" id = "userId" name="userId" placeholder="*id" >
						&nbsp;&nbsp;<button>중복체크</button></td>
				</tr>
				<tr>
					<td><input type="text" id = "userPw" name="userPw" placeholder="*pw" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userPw1" name="userPw1" placeholder="*pw확인" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userName" name="userName" placeholder="*이름" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userBod" name="userBod" placeholder="생년월일" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userTel" name="userTel" placeholder="전화번호" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userEamil" name="userEmail" placeholder="*이메일" ></td>
				</tr>
				<tr>
					<td><input type="text" id = "userAddress" name="userAddress" placeholder="주소" ></td>
				</tr>
			</table>
			<input type="checkbox" name="item"> 나는 동의한다.
			<br><br>
			<input type="reset" value ="취소">&nbsp;&nbsp;
			<input type = "submit" value ="회원가입">
			
			
		</form>
	</div>
</body>
</html>