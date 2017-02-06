<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원목록</h1>
<p><a href='addForm'>신규 회원</a></p>
<table border="1">
<tr>
  <th><c:choose>
    <c:when test="${orderCond == 'MNO_ASC'}">
      <a href="list?orderCond=MNO_DESC">번호↑</a>
    </c:when>
    <c:when test="${orderCond == 'MNO_DESC'}">
      <a href="list?orderCond=MNO_ASC">번호↓</a>
    </c:when>
    <c:otherwise>
      <a href="list?orderCond=MNO_ASC">번호︎</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'NAME_ASC'}">
      <a href="list?orderCond=NAME_DESC">이름↑</a>
    </c:when>
    <c:when test="${orderCond == 'NAME_DESC'}">
      <a href="list?orderCond=NAME_ASC">이름↓</a>
    </c:when>
    <c:otherwise>
      <a href="list?orderCond=NAME_ASC">이름</a>
    </c:otherwise>
  </c:choose></th>  
  <th><c:choose>
    <c:when test="${orderCond == 'EMAIL_ASC'}">
      <a href="list?orderCond=EMAIL_DESC">이메일↑</a>
    </c:when>
    <c:when test="${orderCond == 'EMAIL_DESC'}">
      <a href="list?orderCond=EMAIL_ASC">이메일↓</a>
    </c:when>
    <c:otherwise>
      <a href="list?orderCond=EMAIL_ASC">이메일</a>
    </c:otherwise>
  </c:choose></th>
  <th><c:choose>
    <c:when test="${orderCond == 'CREDATE_ASC'}">
      <a href="list?orderCond=CREDATE_DESC">등록일↑</a>
    </c:when>
    <c:when test="${orderCond == 'CREDATE_DESC'}">
      <a href="list?orderCond=CREDATE_ASC">등록일↓</a>
    </c:when>
    <c:otherwise>
      <a href="list?orderCond=CREDATE_ASC">등록일</a>
    </c:otherwise>
  </c:choose></th>
  <th></th>
</tr>
<c:forEach var="member" items="${list}">
<tr> 
  <td>${member.no}</td>
  <td><a href='update?no=${member.no}'>${member.name}</a></td>
  <td>${member.email}</td>
  <td>${member.createdDate}</td>
  <td><a href='delete?no=${member.no}'>[삭제]</a></td>
</tr>
</c:forEach>
</table>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
