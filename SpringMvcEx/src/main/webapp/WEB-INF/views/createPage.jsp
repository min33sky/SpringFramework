<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목을 넣으세요</title>
</head>
<body>


createPage.jsp

	<form action="/spring/student/create" method="post">
		이름 : <input type="text" name="name" value="${student.name }"><br>
		아이디 : <input type="text" name="id" value="${student.id }"><br>
		<input type="submit" value="전송">
	</form>
 
</body>
</html>