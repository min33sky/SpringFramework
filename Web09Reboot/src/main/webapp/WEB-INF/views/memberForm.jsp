<%-- 프런트 컨트롤러 적용 - 링크에 .do 붙임 --%>
<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 등록</title>
	<style type="text/css">
		#errorMsg {
			color : red;
		}
	</style>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원 등록</h1>
<p id=errorMsg><c:if test="${error == 'duplicateKey' }">이메일 중복</c:if></p>
<p id=errorMsg><c:if test="${error == 'ruleViolation' }">규칙 위반</c:if></p>

<form action='add' method='post'>
	이름: <input type='text' name='name'><br>
	이메일: <input type='text' name='email'><br>
	암호: <input type='password' name='password'><br>
	<input type='submit' value='추가'>
	<input type='button' value='목록' onclick='window.location.href="list"'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
