<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
	<h1>방명록</h1>
	<br/>
	방명록 전체 수:${count }
	<br/>
	<br/>
	<c:forEach items="${list }" var="g">
		${g.id }<br>
		${g.name }<br>
		${g.content }<br>
		${g.regdate }<br>
	</c:forEach>
	<c:forEach items="${pageList}" var="page">
		<a href="list?page=${page }">${page+1 }</a>
	</c:forEach>
	<br/>
	<br/>
	<form method="post" action="write">
		name : <input type="text" name="name">
		<br/>
		<textarea name="content" rows="6" cols="60">
		</textarea>
		<br/>	
		<input type="submit" value="등록">
	</form>
</body>
</html>