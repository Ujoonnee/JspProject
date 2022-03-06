<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
	<!--
	tr.row:hover {
		background-color: lightyellow;
	}
	-->
</style>

<script type="text/javascript">
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>

<div>
	<br />
</div>
<div align="center">
	<div>
		<h1>회원 목록</h1>
	</div>
	<form id="frm" name="frm" action="bulletinSelect.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="200">아이디</th>
				<th width="100">이름</th>
				<th width="100">비밀번호</th>
				<th width="200">주소</th>
			</tr>
			<c:forEach var="member" items="${list }">
				<tr>
					<td align="center">${member.memberId}</td>
					<td align="center">${member.memberName }</td>
					<td align="center">${member.memberPassword }</td>
					<td align="center">${member.memberAddress }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br />
</div>