<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목을 넣으세요</title>
</head>
<body>
	<form action="student" method="post">
		studentId : <input type="text" name="id">
		<input type="submit" value="전송">
	</form> 
	
	<form action="studentView" method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		학년 : <input type="text" name="classNum"><br>
		반 : <input type="text" name="gradeNum"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>