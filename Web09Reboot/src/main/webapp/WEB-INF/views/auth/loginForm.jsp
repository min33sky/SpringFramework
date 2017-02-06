<%-- 프런트 컨트롤러 적용 - 링크에 .do 붙임 --%>
<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
	<style type="text/css">
		#errMsg{
			color: red
		}
	</style>
</head>
<body>
<h2>사용자 로그인</h2>

<p id="errMsg"><c:if test="${loginResult == 'fail' }">해당 회원이 없습니다.</c:if></p>

<form action="login" method="post">
	이메일: <input type="text" name="email"><br>
	암호: <input type="password" name="password"><br>
	<input type="submit" value="로그인">
	<input type="button" value="목록" onclick="window.location.href='/board/member/list'">
</form>
</body>
</html>