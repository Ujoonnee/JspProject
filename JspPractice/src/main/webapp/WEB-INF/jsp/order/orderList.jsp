<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<body>
	<div style="border: solid 1px black; display: inline-block;">
		<select>
			<option></option>
			<option></option>
			<option></option>
			<option></option>
			<option></option>
		</select>
	</div>
	<input type="text" id="searchBox">
	<div style="border: solid 1px black; display: inline-block;"
		id="searchBtn">
		<span>검색</span>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>주문목록</th>
					<th>주문내역</th>
					<th>구매자ID</th>
					<th>구매자이름</th>
					<th>주문일시</th>
				</tr>
			</thead>
			<tbody>
				 <tr>
				<c:forEach items="${arrMap}" var="arrMap">
					<td value="${arrMap.key}">${arrMap.value}</td>
				</c:forEach>
				</tr>
			</tbody>
		</table>
		<button type="button" onclick="location.href='main.do' ">MAIN</button>
	</div>

	<script>
	
	var javaList = '${arrMap}'; //jstl로 받아서 변수 지정 
	var test1 = fn_javaListToJson(javaList); 
	console.log("fn_javaListToJson : ", test1 );
	function fn_javaListToJson(obj){
		var resultJson = []; 
		var str = obj.split('[{').join('').split('}]').join(''); //양끝 문자열 제거 
		var rows = str.split('}, {'); //str는 배열 
		for(var i = 0; rows.length > i; i++){ // rows 배열만큼 for돌림 
			var cols = rows[i].split(', '); 
		var rowData = {}; 
		for(var j = 0; cols.length > j; j++){ 
			var colData = cols[j]; 
			colData = colData.trim(); 
			var key = colData.substring(0, colData.indexOf("="));
			var val = colData.substring(colData.indexOf("=") +1);
			rowData[key] = val; } resultJson.push(rowData); }
		return resultJson; 
		}
	
	


		document.querySelector('#searchBtn').addEventListener('click', () => {
			document.getElementsByTagName('tbody')[0].innerHTML = '';
			$.ajax({
				  //////content type 명시하지 않음
				        type: "get",
				        url : "http://localhost/JspPractice//AjaxController",
				        data : obj,
				        success : function (data){
				        },
				})

			
			
			
			
		})
	</script>
</body>
</html>