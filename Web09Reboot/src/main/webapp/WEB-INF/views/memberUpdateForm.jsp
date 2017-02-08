<%-- 프런트 컨트롤러 적용 - 링크에 .do 붙임 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원정보</title>
	<style type="text/css">
		#errorMsg{
			color: red
		}
	</style>
</head>
<body>
	<h1>회원정보</h1>
	<p id=errorMsg><c:if test="${error == 'duplicateKey' }">이메일 중복</c:if></p>
	<p id=errorMsg><c:if test="${error == 'ruleViolation' }">규칙 위반</c:if></p>
	<form action='update' method='POST'>
		번호: <input type='text' name='no' value='${member.no}' readonly><br>
		이름: <input type='text' name='name' value='${member.name}'><br>
		이메일: <input type='text' name='email' value='${member.email}'><br>
		가입일: ${member.createdDate}<br>
		<input type='submit' value='저장'>
		<input type='button' value='삭제' onclick='location.href="delete?no=${member.no}";'>
		<input type='button' value='취소' onclick='location.href="list"'>
	</form>
</body>
</html>