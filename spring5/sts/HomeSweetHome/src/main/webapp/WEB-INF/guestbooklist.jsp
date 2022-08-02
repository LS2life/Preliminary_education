<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박멱록 목록</title>
</head>
<body>
	<h1>박명록 목록</h1>
	<br/>
	박멱록 전첵수:${count }
	<br/>
	<br/>
	<c:forEach itms="${list }" var="g">
		${g.id }<br>
		${g.name }<br>
		${g.content }<br>
		${g.regdate }<br>
	</c:forEach>
	<c:forEach itms="${page }" var="page">
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
		<br/>
	</form>
</body>
</html>