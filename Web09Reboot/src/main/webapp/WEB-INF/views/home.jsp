<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:forEach var="member" items="${list }">
	<p>${member.no }</p>		
	<p>${member.name }</p>		
	<p>${member.email }</p>		
	<p>${member.password }</p>		
</c:forEach>
</body>
</html>
