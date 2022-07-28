<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first JSP</title>
</head>
<body>
	<a href="/">Home</a>
	<!-- 
		get->주소창에 데이터가 노출 
		post->데이터가 노출이 안된다 
	-->
	<!-- 
	 <form method="get" action="plus">
	 -->	
	<form method="post" action="plus">
		value1:<input type="text" name="value1">
		<br>
		value2:<input type="text" name="value2">
		<br>
		<input type="submit" value="확인">
	</form>
</body>
</html>