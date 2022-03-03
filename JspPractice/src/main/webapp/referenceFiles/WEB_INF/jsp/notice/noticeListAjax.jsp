<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListAjax.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			url: './ajax/noticeList.do',
			type: 'get',
			data: {id:30, name:'Hong'},
			dataType: 'json',
			success: function(result) {
				console.log(result);
//				$('#show').html(result);
				result.forEach(function(item) {
					$('<li>').html(item.id + ' ' + item.title);		// <li>id<li>
					$('#show').html.append(ul);
				})
			},
			error: function(reject) {
				console.log(reject);
				$('#show').html('<h3>status: ' + reject.status + 'error: ' + reject.statusText + '</h3>');
			}
		});
	})
</script>
</head>
<body>
	<div id="show"></div>
</body>
</html>